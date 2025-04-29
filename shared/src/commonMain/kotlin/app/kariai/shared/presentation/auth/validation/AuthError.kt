package app.kariai.shared.presentation.auth.validation

sealed class EmailError {
    object None: app.kariai.shared.presentation.auth.validation.EmailError()
    object InvalidFormat: app.kariai.shared.presentation.auth.validation.EmailError()
}


sealed class PasswordError {
    object None: app.kariai.shared.presentation.auth.validation.PasswordError()
    object Weak: app.kariai.shared.presentation.auth.validation.PasswordError()
}


sealed class ConfirmPasswordError {
    object None: app.kariai.shared.presentation.auth.validation.ConfirmPasswordError()
    object NotMatching: app.kariai.shared.presentation.auth.validation.ConfirmPasswordError()
}