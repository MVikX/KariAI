package app.kariai.api

import app.kariai.storage.auth.UserSessionDto
import app.kariai.storage.userinfo.CompleteDetailsRequest
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*

class AuthApiImpl(private val client: HttpClient) : AuthApi {
    override suspend fun exchangeCode(code: String): UserSessionDto {
        return client.post("https://kariai.app/auth/authorize") {
            contentType(ContentType.Application.FormUrlEncoded)
            setBody(FormDataContent(Parameters.build {
                append("code", code)
            }))
        }.body()
    }

    override suspend fun completeUserDetails(userId: String, request: CompleteDetailsRequest): UserSessionDto {
        return client.post("https://kariai.app/user/details") {
            header("X-User-ID", userId)
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }
}