package app.kariai.shared.presentation.auth.validation

sealed class EmailError {
    object None: EmailError()
    object InvalidFormat: EmailError()
}


sealed class PasswordError {
    object None: PasswordError()
    object Weak: PasswordError()
}


sealed class ConfirmPasswordError {
    object None: ConfirmPasswordError()
    object NotMatching: ConfirmPasswordError()
}