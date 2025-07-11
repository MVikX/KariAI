package app.kariai.composeapp.ui.screens.main.components.stats

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.unit.dp

// style values
private const val SurfaceAlpha = 1f
private val BoxCornerRadius = 15.dp
private val BoxPadding = 25.dp

@Composable
fun StatBoxContainer(
    modifier: Modifier = Modifier,
    onClick: (Offset) -> Unit = {},
    content: @Composable () -> Unit,
) {
    var boxPosition by remember { mutableStateOf(Offset.Zero) }

    Box(
        modifier = modifier
            .onGloballyPositioned { layoutCoordinates ->
                val pos = layoutCoordinates.positionInRoot()
                boxPosition = Offset(pos.x, pos.y)
            }
            .pointerInput(Unit) {
                detectTapGestures { tapOffset ->
                    val globalOffset = boxPosition + tapOffset
                    onClick(globalOffset)
                }
            }
            .background(
                color = MaterialTheme.colorScheme.surface.copy(alpha = SurfaceAlpha),
                shape = RoundedCornerShape(BoxCornerRadius),
            )
            .padding(BoxPadding),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}