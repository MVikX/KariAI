package app.kariai.shared.presentation.auth.register

import app.kariai.shared.presentation.auth.validation.ConfirmPasswordError
import app.kariai.shared.presentation.auth.validation.EmailError
import app.kariai.shared.presentation.auth.validation.PasswordError

data class RegisterUiState(
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val emailError: app.kariai.shared.presentation.auth.validation.EmailError = app.kariai.shared.presentation.auth.validation.EmailError.None,
    val emailWasTouched: Boolean = false,
    val passwordError: app.kariai.shared.presentation.auth.validation.PasswordError = app.kariai.shared.presentation.auth.validation.PasswordError.None,
    val passwordWasTouched: Boolean = false,
    val confirmPasswordError: app.kariai.shared.presentation.auth.validation.ConfirmPasswordError = app.kariai.shared.presentation.auth.validation.ConfirmPasswordError.None,
    val confirmPasswordWasTouched: Boolean = false,
    val isTermsAccepted: Boolean = false,
    val isRegistered: Boolean = false,
)