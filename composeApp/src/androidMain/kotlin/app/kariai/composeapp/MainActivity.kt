package app.kariai.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import app.kariai.shared.viewmodel.getViewModelFactory
import app.kariai.storage.di.provideSettings
import app.kariai.storage.preferences.UserPreferencesImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navState = AppNavigationState()

        setContent {
            val context = LocalContext.current
            val settings = provideSettings(context)
            val userPrefs = UserPreferencesImpl(settings)


            val factory = getViewModelFactory(context)
            val loginVM = factory.createLoginViewModel()
            val registerVM = factory.createRegisterViewModel()
            val userDetailsViewModel = factory.createUserDetailsViewModel()

            App(
                loginViewModel = loginVM,
                registerViewModel = registerVM,
                navigation = navState,
                userDetailsViewModel = userDetailsViewModel,
            )
        }
    }
}