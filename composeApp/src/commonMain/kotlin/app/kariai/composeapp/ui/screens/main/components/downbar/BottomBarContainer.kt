package app.kariai.composeapp.ui.screens.main.components.downbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.unit.dp

// style values
private const val SurfaceAlpha = 1f
private val CornerRadius = 15.dp
private val HorizontalPadding = 25.dp
private val VerticalPadding = 16.dp

@Composable
fun BottomBarContainer(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    var boxPosition by remember { mutableStateOf(Offset.Zero) }

    Box(
        modifier = modifier
            .onGloballyPositioned { layoutCoordinates ->
                val pos = layoutCoordinates.positionInRoot()
                boxPosition = Offset(pos.x, pos.y)
            }
            .background(
                color = MaterialTheme.colorScheme.surface.copy(alpha = SurfaceAlpha),
                shape = RoundedCornerShape(CornerRadius),
            )
            .padding(horizontal = HorizontalPadding, vertical = VerticalPadding),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}