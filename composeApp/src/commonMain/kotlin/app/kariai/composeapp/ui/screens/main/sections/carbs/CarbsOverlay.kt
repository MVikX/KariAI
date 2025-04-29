package app.kariai.composeapp.ui.screens.main.sections.carbs

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import app.kariai.composeapp.ui.screens.main.animations.ExpandingOverlay

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