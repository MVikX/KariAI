package app.kariai.composeapp
//TODO отключены экраны, кнопки входа через..., заглушки для локализации
import androidx.compose.runtime.*
import app.kariai.composeapp.localization.AppLanguage
import app.kariai.composeapp.localization.LocalStrings
import app.kariai.composeapp.localization.YamlStringsProvider
import app.kariai.composeapp.localization.loadYaml
import app.kariai.shared.presentation.auth.login.LoginViewModel
import app.kariai.shared.presentation.auth.register.RegisterViewModel
import app.kariai.shared.presentation.auth.register.userdetails.UserDetailsViewModel
import app.kariai.composeapp.ui.screens.login.LoginScreen
import app.kariai.composeapp.ui.screens.main.MainScreen
import app.kariai.composeapp.ui.screens.register.RegisterScreen
import app.kariai.composeapp.ui.screens.register.userdetails.UserDetailsScreen

/**
 * KariAI — your personal health & nutrition AI assistant.
 *
 * Author: MVikX
 * Development period: since 06.04.2025 – present...
 *
 * Project status: In active development.
 */


enum class AppScreen {
    LOGIN,
    REGISTER,
    USER_DETAILS,
    MAIN,
}

class AppNavigationState {
    //var currentScreen by mutableStateOf(AppScreen.LOGIN)
    //var currentScreen by mutableStateOf(AppScreen.REGISTER)
    //var currentScreen by mutableStateOf(AppScreen.USER_DETAILS)
    var currentScreen by mutableStateOf(AppScreen.MAIN)
}

@Composable
fun App(
    loginViewModel: app.kariai.shared.presentation.auth.login.LoginViewModel,
    registerViewModel: app.kariai.shared.presentation.auth.register.RegisterViewModel,
    userDetailsViewModel: app.kariai.shared.presentation.auth.register.userdetails.UserDetailsViewModel,
    navigation: AppNavigationState = remember { AppNavigationState() },
) {

    val language = AppLanguage.RU //Язык


    val coroutineScope = rememberCoroutineScope()
    var stringsProvider by remember { mutableStateOf<YamlStringsProvider?>(null) }

    LaunchedEffect(language) {
        val yaml = loadYaml(language.code)
        val provider = YamlStringsProvider.fromYamlText(yaml)
        stringsProvider = provider
    }

    if (stringsProvider == null) {
        // заглушка локалки
        androidx.compose.material3.Text("Loading...")
        return
    }

    CompositionLocalProvider(LocalStrings provides stringsProvider!!) {
        when (navigation.currentScreen) {
            AppScreen.LOGIN -> {
                LoginScreen(
                    viewModel = loginViewModel,
                    onSignUpClick = { navigation.currentScreen = AppScreen.REGISTER },
                    onSignInClick = {
                        loginViewModel.onLoginClicked()
                        navigation.currentScreen = AppScreen.MAIN
                    }, //TODO Нужна проверка токена для входа авторизированного
                    onGoogleClick = {

                    },
                    onTelegramClick = {

                    },
                    onAppleClick = {

                    },
                )
            }

            AppScreen.REGISTER -> {
                RegisterScreen(
                    viewModel = registerViewModel,
                    onSignInClick = { navigation.currentScreen = AppScreen.LOGIN },
                    onRegisterClick = {
                        registerViewModel.onRegisterClicked()
                        navigation.currentScreen = AppScreen.USER_DETAILS
                    },
                    onGoogleClick = {
                        navigation.currentScreen = AppScreen.USER_DETAILS
                    },
                    onTelegramClick = {

                    },
                    onAppleClick = {

                    },
                )
            }

            AppScreen.USER_DETAILS -> {
                UserDetailsScreen(
                    viewModel = userDetailsViewModel,
                    onContinueClick = {
                        navigation.currentScreen = AppScreen.MAIN
                    }
                )
            }

            AppScreen.MAIN -> {
                MainScreen()
            }
        }
    }
}