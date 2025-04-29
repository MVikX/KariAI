package app.kariai.composeapp.ui.routes

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import app.kariai.shared.viewmodel.auth.AndroidRegisterViewModel
import app.kariai.storage.di.provideSettings
import app.kariai.storage.preferences.UserPreferencesImpl
import app.kariai.composeapp.ui.screens.register.RegisterScreen

@Composable
fun RegisterRoute(
    onNavigateToLogin: () -> Unit
) {
    val context: Context = LocalContext.current
    val prefs = UserPreferencesImpl(provideSettings(context))

    val viewModel: AndroidRegisterViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return AndroidRegisterViewModel(prefs) as T
            }
        }
    )

    RegisterScreen(
        viewModel = viewModel.delegate,
        onRegisterClick = {
            viewModel.delegate.onRegisterClicked()
            // TODO: переход на следующий экран
        },
        onSignInClick = onNavigateToLogin
    )
}