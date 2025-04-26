package org.example.kariai.storage.di

import com.russhwolf.settings.Settings
import com.russhwolf.settings.NSUserDefaultsSettings
import platform.Foundation.NSUserDefaults

actual fun provideSettings(context: Any?): Settings {
    return NSUserDefaultsSettings(NSUserDefaults.standardUserDefaults)
}