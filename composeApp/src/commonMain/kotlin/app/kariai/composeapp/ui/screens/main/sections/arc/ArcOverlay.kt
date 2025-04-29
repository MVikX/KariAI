package app.kariai.composeapp.ui.screens.main.sections.arc

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import app.kariai.composeapp.ui.screens.main.animations.ExpandingOverlay

@Composable
fun ArcOverlay(
    spentKcal: Int,
    burnedKcal: Int,
    visible: Boolean,
    offset: Offset,
    onDismiss: () -> Unit,
) {
    ExpandingOverlay(
        isVisible = visible,
        origin = offset,
        onDismiss = onDismiss
    ) {
        ArcOverlayScreen(
            onClose = onDismiss,
            spentKcal = spentKcal,
            burnedKcal = burnedKcal,
        )
    }
}