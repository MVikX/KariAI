package app.kariai.shared.viewmodel
//TODO needs factory implementation
import app.kariai.shared.viewmodel.ViewModelFactory
import app.kariai.storage.preferences.UserPreferencesImpl
import app.kariai.storage.di.provideSettings

class IOSViewModelFactory : ViewModelFactory {
    override fun createLoginViewModel(): app.kariai.shared.presentation.auth.login.LoginViewModel {
        val prefs = UserPreferencesImpl(provideSettings(null))
        return app.kariai.shared.presentation.auth.login.LoginViewModel(prefs)
    }

    override fun createRegisterViewModel(): app.kariai.shared.presentation.auth.register.RegisterViewModel {
        val prefs = UserPreferencesImpl(provideSettings(null))
        return app.kariai.shared.presentation.auth.register.RegisterViewModel(prefs)
    }

    override fun createUserDetailsViewModel(): app.kariai.shared.presentation.auth.register.userdetails.UserDetailsViewModel {
        return app.kariai.shared.presentation.auth.register.userdetails.UserDetailsViewModel()
    }
}

actual fun getViewModelFactory(context: Any): ViewModelFactory = IOSViewModelFactory()