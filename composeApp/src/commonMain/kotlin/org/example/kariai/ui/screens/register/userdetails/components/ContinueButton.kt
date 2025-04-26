package org.example.kariai.ui.screens.register.userdetails.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import localization.t
import org.example.kariai.shared.presentation.auth.register.userdetails.UserDetailsUiState
import org.example.kariai.ui.components.common.button.GradientButton
import org.example.kariai.ui.components.common.button.GrayButton

@Composable
fun ContinueButton(uiState: UserDetailsUiState, onClick: () -> Unit) {
    val isFormValid = uiState.gender != null && !uiState.userName.isNullOrBlank()

    if (isFormValid) {
        GradientButton(
            text = t("auth.continue_btn"),
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        )
    } else {
        GrayButton(
            text = t("auth.continue_btn"),
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        )
    }
}