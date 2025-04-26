package org.example.kariai.ui.screens.main.arc

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import org.example.kariai.ui.screens.main.animations.ExpandingOverlay

@Composable
fun ArcOverlay(visible: Boolean, offset: Offset, onDismiss: () -> Unit) {
    ExpandingOverlay(
        isVisible = visible,
        origin = offset,
        onDismiss = onDismiss
    ) {
        ArcOverlayScreen(onClose = onDismiss)
    }
}