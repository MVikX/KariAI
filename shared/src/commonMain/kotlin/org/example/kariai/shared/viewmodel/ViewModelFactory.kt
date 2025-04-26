package org.example.kariai.shared.viewmodel

import org.example.kariai.shared.presentation.auth.login.LoginViewModel
import org.example.kariai.shared.presentation.auth.register.RegisterViewModel
import org.example.kariai.shared.presentation.auth.register.userdetails.UserDetailsViewModel

interface ViewModelFactory {
    fun createLoginViewModel(): LoginViewModel
    fun createRegisterViewModel(): RegisterViewModel
    fun createUserDetailsViewModel(): UserDetailsViewModel
}

expect fun getViewModelFactory(context: Any): ViewModelFactory