package org.example.nutriai.shared.viewmodel.auth

import androidx.lifecycle.ViewModel
import org.example.nutriai.shared.presentation.auth.login.LoginViewModel
import org.example.nutriai.storage.preferences.UserPreferencesImpl

class AndroidLoginViewModel(
    userPreferences: UserPreferencesImpl
) : ViewModel() {
    val delegate = LoginViewModel(userPreferences)
}