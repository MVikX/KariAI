package org.example.kariai.ui.screens.register

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.kariai.resources.NutriTheme
import org.example.kariai.shared.presentation.auth.register.RegisterViewModel
import org.example.kariai.ui.components.SocialSignUpButtonsRow
import org.example.kariai.ui.components.TermsSection
import org.example.kariai.ui.components.auth.ErrorMessage
import org.example.kariai.ui.components.auth.SocialDivider
import org.example.kariai.ui.screens.register.components.*

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel,
    onRegisterClick: () -> Unit = {},
    onGoogleClick: () -> Unit = {},
    onTelegramClick: () -> Unit = {},
    onAppleClick: () -> Unit = {},
    onSignInClick: () -> Unit = {},
) {
    val uiState by viewModel.uiState.collectAsState()


    LaunchedEffect(uiState.isRegistered) {
        if (uiState.isRegistered) {
            onRegisterClick()
        }
    }

    NutriTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Title()
                Spacer(modifier = Modifier.height(32.dp))
/*
                EmailField(uiState, viewModel)
                Spacer(modifier = Modifier.height(16.dp))

                PasswordField(uiState, viewModel)
                Spacer(modifier = Modifier.height(16.dp))

                ConfirmPasswordField(uiState, viewModel)
                Spacer(modifier = Modifier.height(8.dp))

 */

                ErrorMessage(
                    message = uiState.errorMessage,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                )
                Spacer(modifier = Modifier.height(8.dp))

                TermsSection(
                    isChecked = uiState.isTermsAccepted,
                    onCheckedChange = { viewModel.onTermsAcceptedChanged(it) },
                    onTermsClick = {},
                    onPrivacyClick = {}
                )
                Spacer(modifier = Modifier.height(16.dp))


                /*
RegisterButton(uiState) {
    viewModel.onRegisterClicked()
}
 */

                if (uiState.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.padding(top = 16.dp))
                }

                Spacer(modifier = Modifier.height(32.dp))

                SocialDivider()
                Spacer(modifier = Modifier.height(20.dp))

                SocialSignUpButtonsRow(
                    onGoogleClick = onGoogleClick,
                    onTelegramClick = onTelegramClick,
                    onAppleClick = onAppleClick
                )

                Spacer(modifier = Modifier.height(32.dp))


                BottomSignIn(onSignInClick)
            }
        }
    }
}