package app.kariai.composeapp.ui.screens.main.components.week
//TODO добавить логику нажатия
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
                color = MaterialTheme.colorScheme.surface.copy(alpha = 1f),
                shape = RoundedCornerShape(12.dp),
            )
            .padding(12.dp)
    ) {
        content()
    }
}