package org.example.nutriai.shared.presentation.auth.register

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.example.nutriai.shared.domain.validation.EmailValidator
import org.example.nutriai.shared.domain.validation.PasswordValidator
import org.example.nutriai.shared.presentation.auth.validation.ConfirmPasswordError
import org.example.nutriai.shared.presentation.auth.validation.EmailError
import org.example.nutriai.shared.presentation.auth.validation.PasswordError
import org.example.nutriai.storage.preferences.UserPreferencesImpl

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