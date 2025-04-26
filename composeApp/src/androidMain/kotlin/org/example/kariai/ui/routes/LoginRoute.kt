package org.example.kariai.ui.routes

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.kariai.shared.viewmodel.auth.AndroidLoginViewModel
import org.example.kariai.storage.di.provideSettings
import org.example.kariai.storage.preferences.UserPreferencesImpl
import org.example.kariai.ui.screens.login.LoginScreen

@Composable
fun LoginRoute(
    onNavigateToMain: () -> Unit,
    onNavigateToSignUp: () -> Unit,
) {
    // Android Context из Compose
    val context: Context = LocalContext.current

    // Settings  DI
    val userPreferences = UserPreferencesImpl(provideSettings(context))

    // ViewModel
    val viewModel: AndroidLoginViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return AndroidLoginViewModel(userPreferences) as T
            }
        }
    )

    // UI
    LoginScreen(
        viewModel = viewModel.delegate,
        onSignInClick = {
            viewModel.delegate.onLoginClicked()
            onNavigateToMain()
        },
        onSignUpClick = onNavigateToSignUp,
        onGoogleClick = {},
        onTelegramClick = {},
        onAppleClick = {},
    )
}