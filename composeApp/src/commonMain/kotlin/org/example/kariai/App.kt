package org.example.kariai
//TODO отключены экраны, кнопки входа через..., заглушки для локализации
import androidx.compose.runtime.*
import localization.AppLanguage
import localization.LocalStrings
import localization.YamlStringsProvider
import localization.loadYaml
import org.example.kariai.shared.presentation.auth.login.LoginViewModel
import org.example.kariai.shared.presentation.auth.register.RegisterViewModel
import org.example.kariai.shared.presentation.auth.register.userdetails.UserDetailsViewModel
import org.example.kariai.ui.screens.login.LoginScreen
import org.example.kariai.ui.screens.main.MainScreen
import org.example.kariai.ui.screens.register.RegisterScreen
import org.example.kariai.ui.screens.register.userdetails.UserDetailsScreen

//TODO сделать ребрендинг на KariAI
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
    var currentScreen by mutableStateOf(AppScreen.LOGIN)
    //var currentScreen by mutableStateOf(AppScreen.REGISTER)
    //var currentScreen by mutableStateOf(AppScreen.USER_DETAILS)
    //var currentScreen by mutableStateOf(AppScreen.MAIN)
}

@Composable
fun App(
    loginViewModel: LoginViewModel,
    registerViewModel: RegisterViewModel,
    userDetailsViewModel: UserDetailsViewModel,
    navigation: AppNavigationState = remember { AppNavigationState() }
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