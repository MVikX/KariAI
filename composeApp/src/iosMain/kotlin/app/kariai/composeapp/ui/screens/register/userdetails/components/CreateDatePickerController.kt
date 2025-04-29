package app.kariai.composeapp.ui.screens.register.userdetails.components

import androidx.compose.runtime.Composable
import app.kariai.composeapp.ui.screens.register.userdetails.components.DatePickerController

@Composable
actual fun CreateDatePickerController(): DatePickerController {
    return app.kariai.composeapp.ui.screens.register.userdetails.components.DatePickerController()
}