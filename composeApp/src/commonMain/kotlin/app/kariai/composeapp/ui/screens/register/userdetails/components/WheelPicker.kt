package app.kariai.composeapp.ui.screens.register.userdetails.components

import androidx.compose.runtime.Composable

@Composable
expect fun <T> WheelPicker(
    items: List<T>,
    selected: T,
    onSelected: (T) -> Unit
)