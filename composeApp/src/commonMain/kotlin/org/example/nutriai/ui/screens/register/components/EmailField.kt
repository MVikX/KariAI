package org.example.nutriai.ui.screens.register.components

import androidx.compose.runtime.Composable
import localization.t
import org.example.nutriai.resources.GlassTextField
import org.example.nutriai.shared.presentation.auth.register.RegisterUiState
import org.example.nutriai.shared.presentation.auth.register.RegisterViewModel
import org.example.nutriai.shared.presentation.auth.validation.EmailError

@Composable
fun EmailField(uiState: RegisterUiState, viewModel: RegisterViewModel) {
    val emailErrorText = when (uiState.emailError) {
        EmailError.None -> null
        EmailError.InvalidFormat -> t("validation.invalid_email")
    }

    val isValid = uiState.emailError == EmailError.None &&
            uiState.email.isNotBlank() &&
            uiState.emailWasTouched

    GlassTextField(
        label = t("auth.email"),
        placeholder = "name@example.com",
        value = uiState.email,
        onValueChange = { viewModel.onEmailChanged(it) },
        errorMessage = emailErrorText,
        isError = emailErrorText != null && uiState.emailWasTouched,
        isSuccess = isValid
    )
}