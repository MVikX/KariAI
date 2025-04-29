package app.kariai.shared.viewmodel.auth

import androidx.lifecycle.ViewModel
import app.kariai.shared.presentation.auth.login.LoginViewModel
import app.kariai.storage.preferences.UserPreferencesImpl

class AndroidLoginViewModel(
    userPreferences: UserPreferencesImpl
) : ViewModel() {
    val delegate = app.kariai.shared.presentation.auth.login.LoginViewModel(userPreferences)
}