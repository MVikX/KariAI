package org.example.kariai.ui.screens.register.userdetails.components

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun CreateDatePickerController(): DatePickerController {
    val context: Context = LocalContext.current
    return DatePickerController(context)
}