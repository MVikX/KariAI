package org.example.nutriai.storage.preferences

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set

class UserPreferencesImpl(
    private val settings: Settings
) : UserPreferences {

    companion object {
        private const val KEY_AUTH_TOKEN = "auth_token"
        private const val KEY_WEIGHT = "user_weight"
        private const val KEY_HEIGHT = "user_height"
        private const val KEY_AGE = "user_age"
    }

    override fun saveToken(token: String) {
        settings[KEY_AUTH_TOKEN] = token
    }

    override fun saveAge(age: Int) {
        settings[KEY_AGE] = age
    }

    override fun getToken(): String? = settings[KEY_AUTH_TOKEN]

    override fun clearToken() {
        settings.remove(KEY_AUTH_TOKEN)
    }

    override fun saveWeight(weight: Double) {
        settings[KEY_WEIGHT] = weight
    }

    override fun saveHeight(height: Int) {
        settings[KEY_HEIGHT] = height
    }

    override fun getWeight(): Double? = settings.getDoubleOrNull(KEY_WEIGHT)
    override fun getHeight(): Int? = settings.getIntOrNull(KEY_HEIGHT)
    override fun getAge(): Int? = settings.getIntOrNull(KEY_AGE)
}