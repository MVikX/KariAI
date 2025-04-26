package org.example.kariai.shared.viewmodel

import android.content.Context
import org.example.kariai.shared.presentation.auth.login.LoginViewModel
import org.example.kariai.shared.presentation.auth.register.RegisterViewModel
import org.example.kariai.shared.presentation.auth.register.userdetails.UserDetailsViewModel
import org.example.kariai.shared.viewmodel.auth.AndroidLoginViewModel
import org.example.kariai.shared.viewmodel.auth.AndroidRegisterViewModel
import org.example.kariai.storage.di.provideSettings
import org.example.kariai.storage.preferences.UserPreferencesImpl

class AndroidViewModelFactory(
    private val context: Context
) : ViewModelFactory {
    override fun createLoginViewModel(): LoginViewModel {
        val prefs = UserPreferencesImpl(provideSettings(context))
        return AndroidLoginViewModel(prefs).delegate
    }

    override fun createRegisterViewModel(): RegisterViewModel {
        val prefs = UserPreferencesImpl(provideSettings(context))
        return AndroidRegisterViewModel(prefs).delegate
    }

    override fun createUserDetailsViewModel(): UserDetailsViewModel {
        val prefs = UserPreferencesImpl(provideSettings(context))
        return UserDetailsViewModel(prefs)
    }
}

actual fun getViewModelFactory(context: Any): ViewModelFactory {
    require(context is Context) {"Expected Android Context"}
    return AndroidViewModelFactory(context)
}