package app.kariai.composeapp.ui.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.kariai.composeapp.resources.NutriTheme
import app.kariai.shared.presentation.auth.login.LoginViewModel
import app.kariai.composeapp.components.SocialSignInButtonsRow
import app.kariai.composeapp.components.auth.ErrorMessage
import app.kariai.composeapp.ui.screens.login.components.Title

// padding and spacing constants
private val ScreenHorizontalPadding = 24.dp
private val TitleBottomSpacer = 45.dp
private val LoadingTopPadding = 16.dp
private val SocialButtonsTopSpacer = 5.dp

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onSignInClick: () -> Unit = {},
    onGoogleClick: () -> Unit = {},
    onFacebookClick: () -> Unit = {},
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
                    .padding(horizontal = ScreenHorizontalPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Title()

                Spacer(modifier = Modifier.height(TitleBottomSpacer))

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
                    CircularProgressIndicator(Modifier.padding(top = LoadingTopPadding))
                }

                ErrorMessage(
                    message = uiState.errorMessage,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                )

                //SocialDivider()
                Spacer(modifier = Modifier.height(SocialButtonsTopSpacer))

                SocialSignInButtonsRow(
                    onGoogleClick = onGoogleClick,
                    onFacebookClick = onFacebookClick,
                    onAppleClick = onAppleClick
                )

                //Spacer(modifier = Modifier.height(32.dp))


                //BottomSignUp(onSignUpClick)
            }
        }
    }
}