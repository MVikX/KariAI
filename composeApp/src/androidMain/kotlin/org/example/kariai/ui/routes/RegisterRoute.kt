package org.example.kariai.ui.routes

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.kariai.shared.viewmodel.auth.AndroidRegisterViewModel
import org.example.kariai.storage.di.provideSettings
import org.example.kariai.storage.preferences.UserPreferencesImpl
import org.example.kariai.ui.screens.register.RegisterScreen

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