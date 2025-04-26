package org.example.kariai.ui.components

import androidx.compose.runtime.Composable

@Composable
expect fun PlatformTermsBlock(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onTermsClick: () -> Unit,
    onPrivacyClick: () -> Unit
)