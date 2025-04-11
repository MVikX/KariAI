package org.example.nutriai.ui.screens.register.components

import androidx.compose.runtime.Composable
import localization.t
import org.example.nutriai.resources.GlassTextField
import org.example.nutriai.shared.presentation.auth.register.RegisterUiState
import org.example.nutriai.shared.presentation.auth.register.RegisterViewModel
import org.example.nutriai.shared.presentation.auth.validation.ConfirmPasswordError

@Composable
fun ConfirmPasswordField(uiState: RegisterUiState, viewModel: RegisterViewModel) {
    val confirmErrorText = when (uiState.confirmPasswordError) {
        ConfirmPasswordError.None -> null
        ConfirmPasswordError.NotMatching -> t("validation.passwords_not_match")
    }

    val isValid = uiState.confirmPasswordError == ConfirmPasswordError.None &&
            uiState.confirmPasswordWasTouched &&
            uiState.confirmPassword.isNotBlank()

    GlassTextField(
        label = t("auth.confirm_password"),
        placeholder = "••••••••",
        isPassword = true,
        value = uiState.confirmPassword,
        onValueChange = { viewModel.onConfirmPasswordChanged(it) },
        isError = confirmErrorText != null && uiState.confirmPasswordWasTouched,
        isSuccess = isValid,
        errorMessage = confirmErrorText
    )
}