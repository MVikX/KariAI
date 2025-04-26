package org.example.kariai.shared.presentation.auth.register

import org.example.kariai.shared.presentation.auth.validation.ConfirmPasswordError
import org.example.kariai.shared.presentation.auth.validation.EmailError
import org.example.kariai.shared.presentation.auth.validation.PasswordError

data class RegisterUiState(
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val emailError: EmailError = EmailError.None,
    val emailWasTouched: Boolean = false,
    val passwordError: PasswordError = PasswordError.None,
    val passwordWasTouched: Boolean = false,
    val confirmPasswordError: ConfirmPasswordError = ConfirmPasswordError.None,
    val confirmPasswordWasTouched: Boolean = false,
    val isTermsAccepted: Boolean = false,
    val isRegistered: Boolean = false,
)