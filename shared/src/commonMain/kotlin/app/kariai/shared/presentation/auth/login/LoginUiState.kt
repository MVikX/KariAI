package app.kariai.shared.presentation.auth.login

import app.kariai.shared.presentation.auth.validation.EmailError

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val emailError: app.kariai.shared.presentation.auth.validation.EmailError = app.kariai.shared.presentation.auth.validation.EmailError.None,
    val emailWasTouched: Boolean = false,
    val isLoggedIn: Boolean = false,
)