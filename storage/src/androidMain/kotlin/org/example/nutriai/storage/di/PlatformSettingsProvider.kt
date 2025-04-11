package org.example.nutriai.storage.di

import android.content.Context
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings

actual fun provideSettings(context: Any?): Settings {
    val ctx = context as Context
    val prefs = ctx.getSharedPreferences("settings", Context.MODE_PRIVATE)
    return SharedPreferencesSettings(prefs)
}