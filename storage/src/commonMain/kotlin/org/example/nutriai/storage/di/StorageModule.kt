package org.example.nutriai.storage.di

import com.russhwolf.settings.Settings
import org.koin.dsl.module
import org.example.nutriai.storage.preferences.UserPreferencesImpl

val storageModule = module {
    single<Settings> { provideSettings(get()) }
    single { UserPreferencesImpl(get()) }
}