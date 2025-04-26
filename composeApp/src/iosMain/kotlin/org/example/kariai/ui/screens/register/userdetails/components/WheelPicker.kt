package org.example.kariai.ui.screens.register.userdetails.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*

@Composable
actual fun <T> WheelPicker(
    items: List<T>,
    selected: T,
    onSelected: (T) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        items.take(5).forEach { item ->
            Text(text = item.toString())
        }
    }
}