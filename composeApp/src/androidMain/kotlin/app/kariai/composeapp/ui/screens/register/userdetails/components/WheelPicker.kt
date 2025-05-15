package app.kariai.composeapp.ui.screens.register.userdetails.components
// TODO баганная реализация колеса (-1 при старте) Добавить общую тему цвета

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

// UI - размеры, отступы, шрифты
private val WheelItemHeight = 50.dp
private val WheelWidth = 100.dp
private val ArraSpacedBy = 0.dp

private val SelectedFontSize = 30.sp
private val UnselectedFontSize = 18.sp

// цвета и альфа
private const val UnselectedTextAlpha = 0.4f
private const val ShadowAlpha = 0.4f

// логика расчётов и поведения
private const val VisibleItemsCount = 7
private const val CenterPositionDivisor = 2
private const val CenterOffsetFraction = 0.5f

// прокрутка и инициализация
private const val InitialScrollDelayMs = 100
private const val NotFoundIndex = -1
private const val ScrollToStartIndex = 0

@Composable
actual fun <T> WheelPicker(
    items: List<T>,
    selected: T,
    onSelected: (T) -> Unit,
) {
    val itemHeight: Dp = WheelItemHeight
    val visibleItemsCount = VisibleItemsCount
    val centerOffset = visibleItemsCount / CenterPositionDivisor
    val listState = rememberLazyListState()
    val flingBehavior = rememberSnapFlingBehavior(listState)
    val density = LocalDensity.current

    val itemHeightPx = with(density) { itemHeight.toPx() }

    var initialScrollDone by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        if (!initialScrollDone) {
            val index = items.indexOf(selected)
            if (index != NotFoundIndex) {
                delay(InitialScrollDelayMs.toLong())
                listState.scrollToItem(index)
            }
            initialScrollDone = true
        }
    }

    // определение текущего центрального индекса
    val centerIndex by remember {
        derivedStateOf {
            val exactOffset = listState.firstVisibleItemScrollOffset / itemHeightPx
            (listState.firstVisibleItemIndex + exactOffset - CenterOffsetFraction).toInt()
        }
    }

    LaunchedEffect(centerIndex) {
        items.getOrNull(centerIndex)?.let { centered ->
            if (centered != selected) onSelected(centered)
        }
    }

    // защита от выхода за границы при прокрутке
    LaunchedEffect(listState.isScrollInProgress) {
        if (!listState.isScrollInProgress && (centerIndex < ScrollToStartIndex || centerIndex > items.lastIndex)) {
            val safeIndex = centerIndex.coerceIn(ScrollToStartIndex, items.lastIndex)
            listState.animateScrollToItem(safeIndex)
        }
    }

    Box(
        modifier = Modifier
            .height(itemHeight * visibleItemsCount)
            .width(WheelWidth),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            state = listState,
            flingBehavior = flingBehavior,
            contentPadding = PaddingValues(vertical = itemHeight * centerOffset),
            verticalArrangement = Arrangement.spacedBy(ArraSpacedBy),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(items) { _, item ->
                val isSelected = item == selected

                Text(
                    text = item.toString(),
                    fontSize = if (isSelected) SelectedFontSize else UnselectedFontSize,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    color = if (isSelected)
                        Color.White
                    else
                        MaterialTheme.colorScheme.onSurface.copy(alpha = UnselectedTextAlpha),
                    modifier = Modifier
                        .height(itemHeight)
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }

        // затемнение сверху
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(itemHeight * centerOffset)
                .align(Alignment.TopCenter)
                .background(
                    Brush.verticalGradient(
                        listOf(Color.Black.copy(alpha = ShadowAlpha), Color.Transparent)
                    )
                )
        )

        // затемнение снизу
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(itemHeight * centerOffset)
                .align(Alignment.BottomCenter)
                .background(
                    Brush.verticalGradient(
                        listOf(Color.Transparent, Color.Black.copy(alpha = ShadowAlpha))
                    )
                )
        )
    }
}