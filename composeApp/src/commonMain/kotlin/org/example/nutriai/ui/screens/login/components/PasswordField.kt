package org.example.nutriai.ui.screens.login.components

import androidx.compose.runtime.Composable
import org.example.nutriai.resources.GlassTextField
import org.example.nutriai.shared.presentation.auth.login.LoginUiState
import org.example.nutriai.shared.presentation.auth.login.LoginViewModel
import localization.t

@Composable
fun PasswordField(uiState: LoginUiState, viewModel: LoginViewModel) {
    val isValid = uiState.password.isNotBlank()

    GlassTextField(
        label = t("auth.password"),
        placeholder = "••••••••",
        isPassword = true,
        value = uiState.password,
        onValueChange = { viewModel.onPasswordChanged(it) },
        isSuccess = isValid
    )
}