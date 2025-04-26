package org.example.kariai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import org.example.kariai.shared.viewmodel.getViewModelFactory
import org.example.kariai.storage.di.provideSettings
import org.example.kariai.storage.preferences.UserPreferencesImpl

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