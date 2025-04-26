package org.example.kariai.ui.screens.register.userdetails.components

import android.app.DatePickerDialog
import android.content.Context

actual class DatePickerController(private val context: Context) {
    actual fun show(
        initialYear: Int,
        initialMonth: Int,
        initialDay: Int,
        onDateSelected: (year: Int, month: Int, day: Int) -> Unit
    ) {
        DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                onDateSelected(year, month + 1, dayOfMonth)
            },
            initialYear,
            initialMonth - 1,
            initialDay
        ).show()
    }
}