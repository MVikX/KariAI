package org.example.nutriai.shared.viewmodel
//TODO нужно дописать фабрику
import org.example.nutriai.shared.presentation.auth.login.LoginViewModel
import org.example.nutriai.shared.presentation.auth.register.RegisterViewModel
import org.example.nutriai.shared.presentation.auth.register.userdetails.UserDetailsViewModel
import org.example.nutriai.storage.preferences.UserPreferencesImpl
import org.example.nutriai.storage.di.provideSettings

class IOSViewModelFactory : ViewModelFactory {
    override fun createLoginViewModel(): LoginViewModel {
        val prefs = UserPreferencesImpl(provideSettings(null))
        return LoginViewModel(prefs)
    }

    override fun createRegisterViewModel(): RegisterViewModel {
        val prefs = UserPreferencesImpl(provideSettings(null))
        return RegisterViewModel(prefs)
    }

    override fun createUserDetailsViewModel(): UserDetailsViewModel {
        return UserDetailsViewModel()
    }
}

actual fun getViewModelFactory(context: Any): ViewModelFactory = IOSViewModelFactory()