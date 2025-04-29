package app.kariai.shared.viewmodel

interface ViewModelFactory {
    fun createLoginViewModel(): app.kariai.shared.presentation.auth.login.LoginViewModel
    fun createRegisterViewModel(): app.kariai.shared.presentation.auth.register.RegisterViewModel
    fun createUserDetailsViewModel(): app.kariai.shared.presentation.auth.register.userdetails.UserDetailsViewModel
}

expect fun getViewModelFactory(context: Any): ViewModelFactory