package org.example.kariai.ui.screens.main.week

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import org.example.kariai.ui.screens.main.animations.ExpandingOverlay

@Composable
fun WeekOverlay(visible: Boolean, offset: Offset, onDismiss: () -> Unit) {
    ExpandingOverlay(
        isVisible = visible,
        origin = offset,
        onDismiss = onDismiss
    ) {
        WeekOverlayScreen(onClose = onDismiss)
    }
}