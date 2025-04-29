package app.kariai.composeapp.ui.screens.register.userdetails.components

import androidx.compose.runtime.Composable

@Composable
expect fun WeightPickerBottomSheet(
    initialWeight: Double,
    onConfirm: (Double) -> Unit,
    onDismiss: () -> Unit
)