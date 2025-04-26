package org.example.kariai.ui.screens.main.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import org.example.kariai.ui.screens.main.animations.ExpandingOverlay
import org.example.kariai.ui.screens.main.animations.getScreenHeight
import org.example.kariai.ui.screens.main.widget.assistantpanel.AssistantOverlayScreen

@Composable
fun AssistantOverlay(visible: Boolean, onDismiss: () -> Unit) {
    val origin = Offset(
        x = 0f,
        y = getScreenHeight().toFloat()
    )

    ExpandingOverlay(
        isVisible = visible,
        origin = origin,
        onDismiss = onDismiss
    ) {
        AssistantOverlayScreen(onClose = onDismiss)
    }
}