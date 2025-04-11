package org.example.nutriai.shared.presentation.auth.login

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.example.nutriai.shared.domain.validation.EmailValidator
import org.example.nutriai.shared.presentation.auth.validation.EmailError
import org.example.nutriai.storage.preferences.UserPreferencesImpl

class LoginViewModel(
    private val userPreferences: UserPreferencesImpl
) {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

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