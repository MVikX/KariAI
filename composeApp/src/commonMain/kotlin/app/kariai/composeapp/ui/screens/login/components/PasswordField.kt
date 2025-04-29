package app.kariai.composeapp.ui.screens.login.components
/* TODO отключен пароль для входа
import androidx.compose.runtime.Composable
import org.example.kariai.resources.GlassTextField
import org.example.kariai.shared.presentation.auth.login.LoginUiState
import org.example.kariai.shared.presentation.auth.login.LoginViewModel
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

 */