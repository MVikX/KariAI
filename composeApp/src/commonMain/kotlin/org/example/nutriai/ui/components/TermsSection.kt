package org.example.nutriai.ui.components

import androidx.compose.runtime.Composable

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