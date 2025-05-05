package app.kariai.storage.auth

import kotlinx.serialization.Serializable

@Serializable
data class UserSessionDto(
    val userId: String,
    val isDetailsCompleted: Boolean,
    val name: String?,
    val birthDate: String?,
    val height: Double?,
    val weight: Double?,
    val allergies: String?,
    val intolerances: String?,
    val gender: String?
)