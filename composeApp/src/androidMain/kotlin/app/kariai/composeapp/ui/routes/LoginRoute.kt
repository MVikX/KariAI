package app.kariai.composeapp.ui.routes
/*
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import app.kariai.shared.viewmodel.auth.AndroidLoginViewModel
import app.kariai.storage.di.provideSettings
import app.kariai.storage.preferences.UserPreferencesImpl
import app.kariai.composeapp.ui.screens.login.LoginScreen

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

 */