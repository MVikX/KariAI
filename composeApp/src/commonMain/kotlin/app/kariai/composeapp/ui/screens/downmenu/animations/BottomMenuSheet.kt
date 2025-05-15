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

// layout constants
private val BottomSheetHeight = 510.dp
private val BottomSheetMaxHeightFraction = 0.65f
private val BottomSheetOffsetHidden = 500.dp
private val BottomSheetOffsetVisible = 0.dp
private val BottomSheetPadding = 16.dp
private val BottomSheetTopCornerRadius = 0.dp

// opacity
private const val BackgroundOverlayAlpha = 0.3f
private const val BottomSheetAlpha = 0.92f

// dismiss gesture threshold
private const val DragDismissThreshold = 20

@Composable
fun BottomMenuSheet(
    visible: Boolean,
    onDismissRequest: () -> Unit,
    content: @Composable () -> Unit,
) {
    val transition = updateTransition(targetState = visible, label = "menu_transition")
    val offsetY by transition.animateDp(label = "offsetY") {
        if (it) BottomSheetOffsetVisible else BottomSheetOffsetHidden
    }

    if (visible) {
        Box(modifier = Modifier.fillMaxSize()) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(BottomSheetMaxHeightFraction)
                    .background(Color.Black.copy(alpha = BackgroundOverlayAlpha))
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
                    .height(BottomSheetHeight)
                    .align(Alignment.BottomCenter)
                    .offset(y = offsetY)
                    .background(
                        MaterialTheme.colorScheme.surface.copy(alpha = BottomSheetAlpha),
                        shape = RoundedCornerShape(
                            topStart = BottomSheetTopCornerRadius,
                            topEnd = BottomSheetTopCornerRadius
                        )
                    )
                    .pointerInput(Unit) {
                        detectVerticalDragGestures(
                            onDragEnd = {
                                onDismissRequest()
                            },
                            onVerticalDrag = { _, dragAmount ->
                                if (dragAmount > DragDismissThreshold) {
                                    onDismissRequest()
                                }
                            }
                        )
                    }
                    .padding(BottomSheetPadding)
            ) {
                content()
            }
        }
    }
}