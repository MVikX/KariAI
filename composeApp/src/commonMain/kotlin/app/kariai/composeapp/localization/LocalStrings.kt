package app.kariai.composeapp.localization

import androidx.compose.runtime.staticCompositionLocalOf

val LocalStrings = staticCompositionLocalOf<StringsProvider> {
    error("No StringsProvider provided")
}