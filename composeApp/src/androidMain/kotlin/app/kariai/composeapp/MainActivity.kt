package app.kariai.composeapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import app.kariai.auth.service.AuthService
import app.kariai.shared.presentation.auth.login.LoginViewModel
import app.kariai.shared.viewmodel.getViewModelFactory
import app.kariai.storage.di.provideSettings
import app.kariai.storage.preferences.UserPreferencesImpl


class MainActivity : ComponentActivity() {

    private lateinit var authService: AuthService
    private lateinit var loginVM: LoginViewModel

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val context = this
        val settings = provideSettings(context)
        val userPrefs = UserPreferencesImpl(settings)
        val navState = AppNavigationState()

        val factory = getViewModelFactory(context)
        loginVM = factory.createLoginViewModel()
        val registerVM = factory.createRegisterViewModel()
        val userDetailsVM = factory.createUserDetailsViewModel()

        authService = AuthService(this) { code ->
            Log.d("Auth", "Authorization successful! Code: $code")
            loginVM.onGoogleLoginClicked(code)
        }

        intent?.let {
            if (it.action == Intent.ACTION_VIEW && it.data != null) {
                Log.d("Auth", "Received URI in onCreate: ${it.data}")
                authService.handleRedirect(it)
            }
        }

        setContent {
            App(
                loginViewModel = loginVM,
                registerViewModel = registerVM,
                navigation = navState,
                userDetailsViewModel = userDetailsVM,
                authService = authService
            )
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        if (intent.action == Intent.ACTION_VIEW) {
            Log.d("Auth", "Received URI: ${intent.data}")
            authService.handleRedirect(intent)
        }
    }
}