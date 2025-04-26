package org.example.kariai.storage.preferences

interface UserPreferences {
    fun saveToken(token: String)
    fun getToken(): String?
    fun clearToken()

    fun saveUserName(userName: String)
    fun getUserName(): String?

    fun saveBirthDay(day: Int)
    fun getBirthDay(): Int?

    fun saveBirthMonth(month: Int)
    fun getBirthMonth(): Int?

    fun saveBirthYear(year: Int)
    fun getBirthYear(): Int?

    fun saveWeight(weight: Double)
    fun getWeight(): Double?

    fun saveHeight(height: Int)
    fun getHeight(): Int?

    fun saveAge(age: Int)
    fun getAge(): Int?
}