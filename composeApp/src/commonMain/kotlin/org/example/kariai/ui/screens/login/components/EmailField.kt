package org.example.kariai.ui.screens.login.components
/* TODO отключен ввод почты
import androidx.compose.runtime.Composable
import localization.t
import org.example.kariai.resources.GlassTextField
import org.example.kariai.shared.presentation.auth.login.LoginUiState
import org.example.kariai.shared.presentation.auth.login.LoginViewModel
import org.example.kariai.shared.presentation.auth.validation.EmailError

@Composable
fun EmailField(uiState: LoginUiState, viewModel: LoginViewModel) {
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

 */