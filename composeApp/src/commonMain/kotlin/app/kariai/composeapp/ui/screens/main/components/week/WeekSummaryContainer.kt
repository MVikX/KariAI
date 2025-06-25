package app.kariai.composeapp.ui.screens.main.components.week
//TODO add click logic
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.unit.dp

// visual
private const val BackgroundAlpha = 1f
private val CornerRadius = 12.dp
private val ContainerPadding = 12.dp

@Composable
fun WeekSummaryContainer(
    modifier: Modifier = Modifier,
    onClick: (Offset) -> Unit = {},
    content: @Composable () -> Unit,
) {
    val containerPosition = remember { mutableStateOf(Offset.Zero) }

    Box(
        modifier = modifier
            .onGloballyPositioned { coordinates ->
                containerPosition.value = coordinates.positionInRoot()
            }
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    val globalOffset = containerPosition.value + offset
                    onClick(globalOffset)
                }
            }
            .background(
                color = MaterialTheme.colorScheme.surface.copy(alpha = BackgroundAlpha),
                shape = RoundedCornerShape(CornerRadius),
            )
            .padding(ContainerPadding)
    ) {
        content()
    }
}