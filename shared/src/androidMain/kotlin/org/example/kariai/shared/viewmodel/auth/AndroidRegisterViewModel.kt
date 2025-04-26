package org.example.kariai.shared.viewmodel.auth

import androidx.lifecycle.ViewModel
import org.example.kariai.shared.presentation.auth.register.RegisterViewModel
import org.example.kariai.storage.preferences.UserPreferencesImpl

class AndroidRegisterViewModel (
    prefs: UserPreferencesImpl
) : ViewModel() {
    val delegate = RegisterViewModel(prefs)
}