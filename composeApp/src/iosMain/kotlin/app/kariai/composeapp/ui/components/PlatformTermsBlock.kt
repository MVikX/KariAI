package app.kariai.composeapp.ui.components

import androidx.compose.runtime.Composable

@Composable
actual fun PlatformTermsBlock(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onTermsClick: () -> Unit,
    onPrivacyClick: () -> Unit
) {
    //TODO разработка политики конфендециаольности + условия на айфоне
}