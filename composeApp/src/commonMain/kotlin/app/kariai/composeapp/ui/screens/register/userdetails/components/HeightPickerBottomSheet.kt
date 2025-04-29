package app.kariai.composeapp.ui.screens.register.userdetails.components

import androidx.compose.runtime.Composable

@Composable
expect fun HeightPickerBottomSheet(
    initialHeight: Int,
    onConfirm: (Int) -> Unit,
    onDismiss: () -> Unit
)