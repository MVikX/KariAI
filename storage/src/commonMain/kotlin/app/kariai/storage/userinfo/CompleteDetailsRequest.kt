package app.kariai.storage.userinfo

import kotlinx.serialization.Serializable

@Serializable
data class CompleteDetailsRequest(
    val name: String,
    val birthDate: String,
    val height: Double,
    val weight: Double,
    val allergies: String?,
    val intolerances: String?,
    val gender: String?,
    val isDetailsCompleted: Boolean = true,
)