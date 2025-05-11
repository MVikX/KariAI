package app.kariai.composeapp.ui.screens.downmenu.animations

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@Composable
fun BottomMenuSheet(
    visible: Boolean,
    onDismissRequest: () -> Unit,
    content: @Composable () -> Unit,
) {
    val transition = updateTransition(targetState = visible, label = "menu_transition")
    val offsetY by transition.animateDp(label = "offsetY") { if (it) 0.dp else 500.dp }

    if (visible) {
        Box(modifier = Modifier.fillMaxSize()) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.65f)
                    .background(Color.Black.copy(alpha = 0.3f))
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        onDismissRequest()
                    }
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(510.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = offsetY)
                    .background(
                        MaterialTheme.colorScheme.surface.copy(alpha = 0.92f),
                        shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp)
                    )
                    .pointerInput(Unit) {
                        detectVerticalDragGestures(
                            onDragEnd = {
                                onDismissRequest()
                            },
                            onVerticalDrag = { _, dragAmount ->
                                if (dragAmount > 20) {
                                    onDismissRequest()
                                }
                            }
                        )
                    }
                    .padding(16.dp)
            ) {
                content()
            }
        }
    }
}