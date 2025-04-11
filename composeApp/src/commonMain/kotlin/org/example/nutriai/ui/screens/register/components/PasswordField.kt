package org.example.nutriai.ui.screens.register.components

import androidx.compose.runtime.Composable
import localization.t
import org.example.nutriai.resources.GlassTextField
import org.example.nutriai.shared.presentation.auth.register.RegisterUiState
import org.example.nutriai.shared.presentation.auth.register.RegisterViewModel
import org.example.nutriai.shared.presentation.auth.validation.PasswordError

@Composable
fun PasswordField(uiState: RegisterUiState, viewModel: RegisterViewModel) {
    val passwordErrorText = when (uiState.passwordError) {
        PasswordError.None -> null
        PasswordError.Weak -> t("validation.weak_password")
    }

    val isValid = uiState.passwordError == PasswordError.None &&
            uiState.passwordWasTouched &&
            uiState.password.isNotBlank()

    GlassTextField(
        label = t("auth.password"),
        placeholder = "••••••••",
        isPassword = true,
        value = uiState.password,
        onValueChange = { viewModel.onPasswordChanged(it) },
        isError = passwordErrorText != null && uiState.passwordWasTouched,
        isSuccess = isValid,
        errorMessage = passwordErrorText
    )
}