package org.example.kariai.storage.preferences

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set

class UserPreferencesImpl(
    private val settings: Settings
) : UserPreferences {

    companion object {
        private const val KEY_AUTH_TOKEN = "auth_token"
        private const val KEY_USER_NAME = "user_name"
        private const val KEY_BIRTH_DAY = "birth_day"
        private const val KEY_BIRTH_MONTH = "birth_month"
        private const val KEY_BIRTH_YEAR = "birth_year"
        private const val KEY_WEIGHT = "user_weight"
        private const val KEY_HEIGHT = "user_height"
        private const val KEY_AGE = "user_age"
    }

    override fun saveToken(token: String) {
        settings[KEY_AUTH_TOKEN] = token
    }

    override fun getToken(): String? = settings[KEY_AUTH_TOKEN]

    override fun clearToken() {
        settings.remove(KEY_AUTH_TOKEN)
    }



    override fun saveUserName(userName: String) {
        settings[KEY_USER_NAME] = userName
    }

    override fun getUserName(): String? = settings[KEY_USER_NAME]



    override fun saveBirthDay(day: Int) {
        settings[KEY_BIRTH_DAY] = day
    }

    override fun getBirthDay(): Int? = settings.getIntOrNull(KEY_BIRTH_DAY)



    override fun saveBirthMonth(month: Int) {
        settings[KEY_BIRTH_MONTH] = month
    }

    override fun getBirthMonth(): Int? = settings.getIntOrNull(KEY_BIRTH_MONTH)



    override fun saveBirthYear(year: Int) {
        settings[KEY_BIRTH_YEAR] = year
    }

    override fun getBirthYear(): Int? = settings.getIntOrNull(KEY_BIRTH_YEAR)



    override fun saveWeight(weight: Double) {
        settings[KEY_WEIGHT] = weight
    }

    override fun getWeight(): Double? = settings.getDoubleOrNull(KEY_WEIGHT)



    override fun saveHeight(height: Int) {
        settings[KEY_HEIGHT] = height
    }

    override fun getHeight(): Int? = settings.getIntOrNull(KEY_HEIGHT)



    override fun saveAge(age: Int) {
        settings[KEY_AGE] = age
    }

    override fun getAge(): Int? = settings.getIntOrNull(KEY_AGE)
}