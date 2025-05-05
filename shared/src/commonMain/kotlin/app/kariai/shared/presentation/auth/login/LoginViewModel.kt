package app.kariai.shared.presentation.auth.login

import app.kariai.auth.controller.AuthController
import app.kariai.shared.domain.validation.EmailValidator
import app.kariai.shared.presentation.auth.validation.EmailError
import app.kariai.storage.preferences.UserPreferencesImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel(
    private val userPreferences: UserPreferencesImpl,
    private val authController: AuthController
) {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEmailChanged(newEmail: String) {
        val isValid = EmailValidator.isValid(newEmail)
        val error = if (isValid) EmailError.None else EmailError.InvalidFormat

        _uiState.update {
            it.copy(
                email = newEmail,
                emailError = error,
                emailWasTouched = true
            )
        }
    }

    fun onPasswordChanged(newPassword: String) {
        _uiState.update { it.copy(password = newPassword) }
    }

    fun onLoginClicked() {
        _uiState.update {
            it.copy(
                isLoading = true,
                errorMessage = null
            )
        }
    }

    fun onGoogleLoginClicked(code: String) {
        _uiState.update { it.copy(isLoading = true) }

        authController.exchangeCode(
            code = code,
            onSuccess = { session ->
                userPreferences.saveUserId(session.userId)

                println("✅ User session: $session")
                println("🔍 userId: ${session.userId}")
                println("🔍 isDetailsCompleted: ${session.isDetailsCompleted}")
                println("🔍 name: ${session.name}")
                println("🔍 birthDate: ${session.birthDate}")
                println("🔍 height: ${session.height}")
                println("🔍 weight: ${session.weight}")
                println("🔍 allergies: ${session.allergies}")
                println("🔍 intolerances: ${session.intolerances}")
                println("🔍 gender: ${session.gender}")

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isLoggedIn = true,
                        isUserDetailsCompleted = session.isDetailsCompleted
                    )
                }
            },
            onError = { error ->
                println("Ошибка авторизации: ${error.message}")
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = error.message
                    )
                }
            }
        )
    }
}