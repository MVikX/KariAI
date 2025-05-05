package app.kariai.api

import app.kariai.storage.auth.UserSessionDto
import app.kariai.storage.userinfo.CompleteDetailsRequest

interface AuthApi {
    suspend fun exchangeCode(
        code: String
    ): UserSessionDto

    suspend fun completeUserDetails(
        userId: String, request: CompleteDetailsRequest
    ): UserSessionDto
}