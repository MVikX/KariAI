package app.kariai.composeapp.ui.screens.login.components
/* TODO login button is disabled
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import localization.t
import org.example.kariai.shared.presentation.auth.login.LoginUiState
import org.example.kariai.shared.presentation.auth.validation.EmailError
import org.example.kariai.ui.components.common.button.GradientButton
import org.example.kariai.ui.components.common.button.GrayButton


@Composable
fun LoginButton(uiState: LoginUiState, onClick: () -> Unit) {
    val isFormValid = uiState.emailError == EmailError.None &&
            uiState.email.isNotBlank() &&
            uiState.password.isNotBlank()

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