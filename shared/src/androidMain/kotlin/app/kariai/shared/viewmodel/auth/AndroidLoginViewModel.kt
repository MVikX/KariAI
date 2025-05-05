package app.kariai.shared.viewmodel.auth

import androidx.lifecycle.ViewModel
import app.kariai.auth.controller.AuthController
import app.kariai.shared.presentation.auth.login.LoginViewModel
import app.kariai.storage.preferences.UserPreferencesImpl

class AndroidLoginViewModel(
    userPreferences: UserPreferencesImpl,
    authController: AuthController
) : ViewModel() {
    val delegate = LoginViewModel(userPreferences, authController)
}