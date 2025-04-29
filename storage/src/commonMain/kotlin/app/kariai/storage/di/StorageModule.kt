package app.kariai.storage.di

import com.russhwolf.settings.Settings
import org.koin.dsl.module
import app.kariai.storage.preferences.UserPreferencesImpl

val storageModule = module {
    single<Settings> { provideSettings(get()) }
    single { UserPreferencesImpl(get()) }
}