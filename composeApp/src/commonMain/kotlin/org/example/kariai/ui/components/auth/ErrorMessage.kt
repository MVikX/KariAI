package org.example.kariai.ui.components.auth

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun ErrorMessage(
    message: String?,
    modifier: Modifier = Modifier
) {
    message?.let {
        Text(
            text = it,
            color = MaterialTheme.colorScheme.error,
            fontSize = 14.sp,
            modifier = modifier
        )
    }
}