package app.kariai.shared.viewmodel

import app.kariai.shared.presentation.auth.login.LoginViewModel
import app.kariai.shared.presentation.auth.register.RegisterViewModel
import app.kariai.shared.presentation.auth.register.userdetails.UserDetailsViewModel

interface ViewModelFactory {
    fun createLoginViewModel(): LoginViewModel
    fun createRegisterViewModel(): RegisterViewModel
    fun createUserDetailsViewModel(): UserDetailsViewModel
}

expect fun getViewModelFactory(context: Any): ViewModelFactory