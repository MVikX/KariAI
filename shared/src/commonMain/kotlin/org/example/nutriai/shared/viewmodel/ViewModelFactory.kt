package org.example.nutriai.shared.viewmodel

import org.example.nutriai.shared.presentation.auth.login.LoginViewModel
import org.example.nutriai.shared.presentation.auth.register.RegisterViewModel
import org.example.nutriai.shared.presentation.auth.register.userdetails.UserDetailsViewModel

interface ViewModelFactory {
    fun createLoginViewModel(): LoginViewModel
    fun createRegisterViewModel(): RegisterViewModel
    fun createUserDetailsViewModel(): UserDetailsViewModel
}

expect fun getViewModelFactory(context: Any): ViewModelFactory