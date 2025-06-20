package app.kariai.composeapp.ui.screens.register.components
/* TODO registration button is disabled
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.kariai.shared.presentation.auth.register.RegisterUiState
import org.example.kariai.shared.presentation.auth.validation.ConfirmPasswordError
import org.example.kariai.shared.presentation.auth.validation.EmailError
import org.example.kariai.shared.presentation.auth.validation.PasswordError
import org.example.kariai.ui.components.common.button.GradientButton
import org.example.kariai.ui.components.common.button.GrayButton
import localization.t

@Composable
fun RegisterButton(uiState: RegisterUiState, onClick: () -> Unit) {
    val isFormValid = uiState.isTermsAccepted &&
            uiState.emailError == EmailError.None &&
            uiState.passwordError == PasswordError.None &&
            uiState.confirmPasswordError == ConfirmPasswordError.None &&
            uiState.email.isNotBlank() &&
            uiState.password.isNotBlank() &&
            uiState.confirmPassword.isNotBlank()

    if (isFormValid) {
        GradientButton(
            text = t("auth.sign_in"),
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        )
    } else {
        GrayButton(
            text = t("auth.sign_in"),
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        )
    }
}

 */