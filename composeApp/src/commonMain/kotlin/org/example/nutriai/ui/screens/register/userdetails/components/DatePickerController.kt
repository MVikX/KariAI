package org.example.nutriai.ui.screens.register.userdetails.components

expect class DatePickerController {
    fun show(
        initialYear: Int,
        initialMonth: Int,
        initialDay: Int,
        onDateSelected: (year: Int, month: Int, day: Int) -> Unit
    )
}