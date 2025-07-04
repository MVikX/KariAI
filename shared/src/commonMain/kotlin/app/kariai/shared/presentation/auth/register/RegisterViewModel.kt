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
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState

    fun onEmailChanged(newEmail: String) {
        val isValid = EmailValidator.isValid(newEmail)
        val error = if(isValid) EmailError.None else EmailError.InvalidFormat

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
        val error = if (isStrong) PasswordError.None else PasswordError.Weak


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
        val error = if (isMatching) ConfirmPasswordError.None else
            ConfirmPasswordError.NotMatching


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

        // emulation of "successful registration"
        userPreferences.saveToken("fake_token_123")

        _uiState.update {
            it.copy(
                isLoading = false,
                errorMessage = null,
                isRegistered = true,
            )
        }
    }


    fun onTermsAcceptedChanged(accepted: Boolean) {
        _uiState.update { it.copy(isTermsAccepted = accepted) }
    }
}