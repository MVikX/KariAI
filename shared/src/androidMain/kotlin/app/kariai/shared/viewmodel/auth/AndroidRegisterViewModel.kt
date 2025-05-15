package app.kariai.shared.viewmodel.auth

import androidx.lifecycle.ViewModel
import app.kariai.shared.presentation.auth.register.RegisterViewModel
import app.kariai.storage.preferences.UserPreferencesImpl

class AndroidRegisterViewModel (
    prefs: UserPreferencesImpl
) : ViewModel() {
    val delegate = RegisterViewModel(prefs)
}