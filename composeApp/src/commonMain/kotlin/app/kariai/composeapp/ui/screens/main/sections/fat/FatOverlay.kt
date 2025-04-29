package app.kariai.composeapp.ui.screens.main.sections.fat

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import app.kariai.composeapp.ui.screens.main.animations.ExpandingOverlay

@Composable
fun FatOverlay(visible: Boolean, offset: Offset, onDismiss: () -> Unit) {
    ExpandingOverlay(
        isVisible = visible,
        origin = offset,
        onDismiss = onDismiss
    ) {
        FatOverlayScreen(onClose = onDismiss)
    }
}