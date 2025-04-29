package app.kariai.composeapp.components

import androidx.compose.runtime.Composable
import app.kariai.composeapp.ui.components.PlatformTermsBlock

@Composable
fun TermsSection(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onTermsClick: () -> Unit,
    onPrivacyClick: () -> Unit,
) {
    PlatformTermsBlock(
        isChecked = isChecked,
        onCheckedChange = onCheckedChange,
        onTermsClick = onTermsClick,
        onPrivacyClick = onPrivacyClick
    )
}