package app.kariai.composeapp

import androidx.compose.ui.window.ComposeUIViewController
import app.kariai.shared.viewmodel.getViewModelFactory
import platform.UIKit.UIViewController
//TODO Требует дописания
fun MainViewController(): UIViewController {
    val factory = getViewModelFactory(Unit)

    return ComposeUIViewController {
        App(
            loginViewModel = factory.createLoginViewModel(),
            registerViewModel = factory.createRegisterViewModel()
        )
    }
}