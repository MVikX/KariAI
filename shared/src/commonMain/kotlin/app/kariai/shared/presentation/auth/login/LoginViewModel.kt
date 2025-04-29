package app.kariai.shared.presentation.auth.login

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import app.kariai.shared.domain.validation.EmailValidator
import app.kariai.shared.presentation.auth.validation.EmailError
import app.kariai.storage.preferences.UserPreferencesImpl

class LoginViewModel(
    private val userPreferences: UserPreferencesImpl
) {
    private val _uiState = MutableStateFlow(app.kariai.shared.presentation.auth.login.LoginUiState())
    val uiState: StateFlow<app.kariai.shared.presentation.auth.login.LoginUiState> = _uiState

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
        _uiState.update { it.copy(password = newPassword) }
    }

    fun onLoginClicked() {
        _uiState.update { it.copy(isLoading = true, errorMessage = null) }

        // эмуляция авторизации
        userPreferences.saveToken("fake_token_123")

        _uiState.update { it.copy(
            isLoading = false,
            errorMessage = null,
            isLoggedIn = true,
        ) }
    }
}