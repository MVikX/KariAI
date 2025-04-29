package app.kariai.shared.viewmodel

import android.content.Context
import app.kariai.shared.viewmodel.auth.AndroidLoginViewModel
import app.kariai.shared.viewmodel.auth.AndroidRegisterViewModel
import app.kariai.storage.di.provideSettings
import app.kariai.storage.preferences.UserPreferencesImpl

class AndroidViewModelFactory(
    private val context: Context
) : ViewModelFactory {
    override fun createLoginViewModel(): app.kariai.shared.presentation.auth.login.LoginViewModel {
        val prefs = UserPreferencesImpl(provideSettings(context))
        return AndroidLoginViewModel(prefs).delegate
    }

    override fun createRegisterViewModel(): app.kariai.shared.presentation.auth.register.RegisterViewModel {
        val prefs = UserPreferencesImpl(provideSettings(context))
        return AndroidRegisterViewModel(prefs).delegate
    }

    override fun createUserDetailsViewModel(): app.kariai.shared.presentation.auth.register.userdetails.UserDetailsViewModel {
        val prefs = UserPreferencesImpl(provideSettings(context))
        return app.kariai.shared.presentation.auth.register.userdetails.UserDetailsViewModel(prefs)
    }
}

actual fun getViewModelFactory(context: Any): ViewModelFactory {
    require(context is Context) {"Expected Android Context"}
    return AndroidViewModelFactory(context)
}