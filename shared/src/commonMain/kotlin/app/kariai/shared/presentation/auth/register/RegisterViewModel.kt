package app.kariai.shared.presentation.auth.register

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import app.kariai.shared.domain.validation.EmailValidator
import app.kariai.shared.domain.validation.PasswordValidator
import app.kariai.shared.presentation.auth.validation.ConfirmPasswordError
import app.kariai.shared.presentation.auth.validation.EmailError
import app.kariai.shared.presentation.auth.validation.PasswordError
import app.kariai.storage.preferences.UserPreferencesImpl

class RegisterViewModel (
    private val userPreferences: UserPreferencesImpl
) {
    private val _uiState = MutableStateFlow(app.kariai.shared.presentation.auth.register.RegisterUiState())
    val uiState: StateFlow<app.kariai.shared.presentation.auth.register.RegisterUiState> = _uiState

    fun onEmailChanged(newEmail: String) {
        val isValid = EmailValidator.isValid(newEmail)
        val error = if(isValid) app.kariai.shared.presentation.auth.validation.EmailError.None else app.kariai.shared.presentation.auth.validation.EmailError.InvalidFormat

        _uiState.update {
            it.copy(
                email = newEmail,
                emailError = error,
                emailWasTouched = true,
            )
        }
    }

    fun onPasswordChanged(newPassword: String) {
        val isStrong = PasswordValidator.isStrong(newPassword)
        val error = if (isStrong) app.kariai.shared.presentation.auth.validation.PasswordError.None else app.kariai.shared.presentation.auth.validation.PasswordError.Weak


        _uiState.update {
            it.copy(
                password = newPassword,
                passwordError = error,
                passwordWasTouched = true,
            )
        }
    }


    fun onConfirmPasswordChanged (newPassword: String) {
        val isMatching = newPassword == _uiState.value.password
        val error = if (isMatching) app.kariai.shared.presentation.auth.validation.ConfirmPasswordError.None else
            app.kariai.shared.presentation.auth.validation.ConfirmPasswordError.NotMatching


        _uiState.update {
            it.copy(
                confirmPassword = newPassword,
                confirmPasswordError = error,
                confirmPasswordWasTouched = true,
            )
        }
    }


    fun onRegisterClicked() {
        _uiState.update {
            it.copy(isLoading = true, errorMessage = null)
        }

        // эмуляция "успешной регистрации"
        userPreferences.saveToken("fake_token_123")

        _uiState.update {
            it.copy(
                isLoading = false,
                errorMessage = null,
                isRegistered = true,
            )
        }

        //onRegisterClick() перекидывание на мэин
    }


    fun onTermsAcceptedChanged(accepted: Boolean) {
        _uiState.update { it.copy(isTermsAccepted = accepted) }
    }
}