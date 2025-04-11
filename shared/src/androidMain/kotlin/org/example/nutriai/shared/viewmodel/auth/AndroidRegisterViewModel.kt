package org.example.nutriai.shared.viewmodel.auth

import androidx.lifecycle.ViewModel
import org.example.nutriai.shared.presentation.auth.register.RegisterViewModel
import org.example.nutriai.storage.preferences.UserPreferencesImpl

class AndroidRegisterViewModel (
    prefs: UserPreferencesImpl
) : ViewModel() {
    val delegate = RegisterViewModel(prefs)
}