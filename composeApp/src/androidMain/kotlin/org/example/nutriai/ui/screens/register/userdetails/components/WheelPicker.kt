package org.example.nutriai.ui.screens.register.userdetails.components
//todo баганная реализация колеса (-1 при старте)
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
actual fun <T> WheelPicker(
    items: List<T>,
    selected: T,
    onSelected: (T) -> Unit
) {
    val itemHeight: Dp = 50.dp
    val visibleItemsCount = 7
    val centerOffset = visibleItemsCount / 2
    val listState = rememberLazyListState()
    val flingBehavior = rememberSnapFlingBehavior(listState)
    val density = LocalDensity.current

    val itemHeightPx = with(density) { itemHeight.toPx() }

    var initialScrollDone by remember { mutableStateOf(false) }


    LaunchedEffect(Unit) {
        if (!initialScrollDone) {
            val index = items.indexOf(selected)
            if (index != -1) {
                delay(100)
                listState.scrollToItem(index)
            }
            initialScrollDone = true
        }
    }



    val centerIndex by remember {
        derivedStateOf {
            val exactOffset = listState.firstVisibleItemScrollOffset / itemHeightPx
            (listState.firstVisibleItemIndex + exactOffset - 0.5f).toInt()
        }
    }


    LaunchedEffect(centerIndex) {
        items.getOrNull(centerIndex)?.let { centered ->
            if (centered != selected) onSelected(centered)
        }
    }


    LaunchedEffect(listState.isScrollInProgress) {
        if (!listState.isScrollInProgress && (centerIndex < 0 || centerIndex > items.lastIndex)) {
            val safeIndex = centerIndex.coerceIn(0, items.lastIndex)
            listState.animateScrollToItem(safeIndex)
        }
    }


    Box(
        modifier = Modifier
            .height(itemHeight * visibleItemsCount)
            .width(100.dp),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            state = listState,
            flingBehavior = flingBehavior,
            contentPadding = PaddingValues(vertical = itemHeight * centerOffset),
            verticalArrangement = Arrangement.spacedBy(0.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(items) { _, item ->
                val isSelected = item == selected

                Text(
                    text = item.toString(),
                    fontSize = if (isSelected) 30.sp else 18.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    color = if (isSelected)
                        Color.White
                    else
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f),
                    modifier = Modifier
                        .height(itemHeight)
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(itemHeight * centerOffset)
                .align(Alignment.TopCenter)
                .background(
                    Brush.verticalGradient(
                        listOf(Color.Black.copy(alpha = 0.4f), Color.Transparent)
                    )
                )
        )


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(itemHeight * centerOffset)
                .align(Alignment.BottomCenter)
                .background(
                    Brush.verticalGradient(
                        listOf(Color.Transparent, Color.Black.copy(alpha = 0.4f))
                    )
                )
        )
    }
}