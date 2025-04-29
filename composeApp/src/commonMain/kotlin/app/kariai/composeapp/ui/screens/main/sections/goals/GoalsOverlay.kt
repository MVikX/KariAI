package app.kariai.composeapp.ui.screens.main.sections.goals

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import app.kariai.composeapp.ui.screens.main.animations.ExpandingOverlay

@Composable
fun GoalsOverlay(visible: Boolean, offset: Offset, onDismiss: () -> Unit) {
    ExpandingOverlay(
        isVisible = visible,
        origin = offset,
        onDismiss = onDismiss
    ) {
        GoalsOverlayScreen(onClose = onDismiss)
    }
}