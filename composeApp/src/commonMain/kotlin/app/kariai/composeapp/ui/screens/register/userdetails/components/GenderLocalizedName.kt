package app.kariai.composeapp.ui.screens.register.userdetails.components

import androidx.compose.runtime.Composable
import app.kariai.composeapp.localization.t
import app.kariai.shared.presentation.auth.register.userdetails.enums.Gender

fun app.kariai.shared.presentation.auth.register.userdetails.enums.Gender.rawKey(): String = when (this) {
    app.kariai.shared.presentation.auth.register.userdetails.enums.Gender.MALE -> "profile.gender_men"
    app.kariai.shared.presentation.auth.register.userdetails.enums.Gender.FEMALE -> "profile.gender_woman"
}

@Composable
fun app.kariai.shared.presentation.auth.register.userdetails.enums.Gender.localizedName(): String = t(this.rawKey())