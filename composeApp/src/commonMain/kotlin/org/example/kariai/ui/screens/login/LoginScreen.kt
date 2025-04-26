package org.example.kariai.ui.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.kariai.resources.NutriTheme
import org.example.kariai.shared.presentation.auth.login.LoginViewModel
import org.example.kariai.ui.components.SocialSignInButtonsRow
import org.example.kariai.ui.components.auth.ErrorMessage
import org.example.kariai.ui.components.auth.SocialDivider
import org.example.kariai.ui.screens.login.components.*

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onSignInClick: () -> Unit = {},
    onGoogleClick: () -> Unit = {},
    onTelegramClick: () -> Unit = {},
    onAppleClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {},
) {
    val uiState by viewModel.uiState.collectAsState()


    LaunchedEffect(uiState.isLoggedIn) {
        if (uiState.isLoggedIn) {
            onSignInClick()
        }
    }


    NutriTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
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
                Spacer(modifier = Modifier.height(24.dp))

                LoginButton(uiState) {
                    viewModel.onLoginClicked()
                }

 */

                if (uiState.isLoading) {
                    CircularProgressIndicator(Modifier.padding(top = 16.dp))
                }

                ErrorMessage(
                    message = uiState.errorMessage,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                )
                Spacer(modifier = Modifier.height(32.dp))

                SocialDivider()
                Spacer(modifier = Modifier.height(20.dp))

                SocialSignInButtonsRow(
                    onGoogleClick = onGoogleClick,
                    onTelegramClick = onTelegramClick,
                    onAppleClick = onAppleClick
                )

                Spacer(modifier = Modifier.height(32.dp))


                BottomSignUp(onSignUpClick)
            }
        }
    }
}