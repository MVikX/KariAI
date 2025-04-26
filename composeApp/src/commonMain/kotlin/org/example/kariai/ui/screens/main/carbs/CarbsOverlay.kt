package org.example.kariai.ui.screens.main.carbs

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import org.example.kariai.ui.screens.main.animations.ExpandingOverlay

@Composable
fun CarbsOverlay(visible: Boolean, offset: Offset, onDismiss: () -> Unit) {
    ExpandingOverlay(
        isVisible = visible,
        origin = offset,
        onDismiss = onDismiss
    ) {
        CarbsOverlayScreen(onClose = onDismiss)
    }
}