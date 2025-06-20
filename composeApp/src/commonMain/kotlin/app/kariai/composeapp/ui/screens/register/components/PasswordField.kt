package app.kariai.composeapp.ui.screens.register.components
/* TODO password input is disabled
import androidx.compose.runtime.Composable
import localization.t
import org.example.kariai.resources.GlassTextField
import org.example.kariai.shared.presentation.auth.register.RegisterUiState
import org.example.kariai.shared.presentation.auth.register.RegisterViewModel
import org.example.kariai.shared.presentation.auth.validation.PasswordError

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

 */