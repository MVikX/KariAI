package org.example.kariai.shared.viewmodel.auth

import androidx.lifecycle.ViewModel
import org.example.kariai.shared.presentation.auth.login.LoginViewModel
import org.example.kariai.storage.preferences.UserPreferencesImpl

class AndroidLoginViewModel(
    userPreferences: UserPreferencesImpl
) : ViewModel() {
    val delegate = LoginViewModel(userPreferences)
}