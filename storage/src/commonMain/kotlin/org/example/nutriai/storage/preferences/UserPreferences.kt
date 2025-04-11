package org.example.nutriai.storage.preferences

interface UserPreferences {
    fun saveToken(token: String)
    fun getToken(): String?
    fun clearToken()

    fun saveWeight(weight: Double)
    fun getWeight(): Double?

    fun saveHeight(height: Int)
    fun getHeight(): Int?

    fun saveAge(age: Int)
    fun getAge(): Int?
}