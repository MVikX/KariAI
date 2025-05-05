package app.kariai.auth.controller

import app.kariai.api.AuthApi
import app.kariai.storage.auth.UserSessionDto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

class AuthController(
    private val authApi: AuthApi
) {
    fun exchangeCode(
        code: String,
        onSuccess: (UserSessionDto) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val session = authApi.exchangeCode(code)
                onSuccess(session)
            } catch (e: Exception) {
                onError(e)
            }
        }
    }
}