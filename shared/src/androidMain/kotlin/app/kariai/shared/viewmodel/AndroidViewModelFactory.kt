package app.kariai.shared.viewmodel

import android.content.Context
import app.kariai.api.AuthApiImpl
import app.kariai.api.defaultHttpClient
import app.kariai.auth.controller.AuthController
import app.kariai.shared.presentation.auth.login.LoginViewModel
import app.kariai.shared.presentation.auth.register.RegisterViewModel
import app.kariai.shared.presentation.auth.register.userdetails.UserDetailsViewModel
import app.kariai.shared.viewmodel.auth.AndroidLoginViewModel
import app.kariai.shared.viewmodel.auth.AndroidRegisterViewModel
import app.kariai.storage.di.provideSettings
import app.kariai.storage.preferences.UserPreferencesImpl

class AndroidViewModelFactory(
    private val context: Context
) : ViewModelFactory {
    override fun createLoginViewModel(): LoginViewModel {
        val prefs = UserPreferencesImpl(provideSettings(context))
        val authApi = AuthApiImpl(defaultHttpClient)
        val controller = AuthController(authApi)
        return AndroidLoginViewModel(prefs, controller).delegate
    }

    override fun createRegisterViewModel(): RegisterViewModel {
        val prefs = UserPreferencesImpl(provideSettings(context))
        return AndroidRegisterViewModel(prefs).delegate
    }

    override fun createUserDetailsViewModel(): UserDetailsViewModel {
        val prefs = UserPreferencesImpl(provideSettings(context))
        val authApi = AuthApiImpl(defaultHttpClient)
        return UserDetailsViewModel(prefs, authApi)
    }
}

actual fun getViewModelFactory(context: Any): ViewModelFactory {
    require(context is Context) {"Expected Android Context"}
    return AndroidViewModelFactory(context)
}