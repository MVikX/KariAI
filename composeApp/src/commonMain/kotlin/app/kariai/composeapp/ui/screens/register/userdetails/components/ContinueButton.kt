package app.kariai.composeapp.ui.screens.register.userdetails.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.kariai.composeapp.localization.t
import app.kariai.shared.presentation.auth.register.userdetails.UserDetailsUiState
import app.kariai.composeapp.components.common.button.GradientButton
import app.kariai.composeapp.components.common.button.GrayButton

@Composable
fun ContinueButton(
    uiState: UserDetailsUiState,
    onClick: () -> Unit
) {
    val isFormValid = uiState.gender != null &&
            !uiState.userName.isNullOrBlank()

    if (isFormValid) {
        AnimatedBorderWrapper(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            cornerRadius = 16.dp,
            strokeWidth = 2.dp
        ) {
            GradientButton(
                text = t("auth.continue_btn"),
                onClick = onClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            )
        }
    } else {
        GrayButton(
            text = t("auth.continue_btn"),
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        )
    }
}