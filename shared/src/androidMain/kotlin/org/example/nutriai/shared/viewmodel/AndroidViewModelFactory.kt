package org.example.nutriai.shared.viewmodel

import android.content.Context
import org.example.nutriai.shared.presentation.auth.login.LoginViewModel
import org.example.nutriai.shared.presentation.auth.register.RegisterViewModel
import org.example.nutriai.shared.presentation.auth.register.userdetails.UserDetailsViewModel
import org.example.nutriai.shared.viewmodel.auth.AndroidLoginViewModel
import org.example.nutriai.shared.viewmodel.auth.AndroidRegisterViewModel
import org.example.nutriai.storage.di.provideSettings
import org.example.nutriai.storage.preferences.UserPreferencesImpl

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