package org.example.nutriai.ui.screens.register.userdetails.components

import androidx.compose.runtime.Composable
import localization.t
import org.example.nutriai.shared.presentation.auth.register.userdetails.enums.Gender

fun Gender.rawKey(): String = when (this) {
    Gender.MALE -> "profile.gender_men"
    Gender.FEMALE -> "profile.gender_woman"
}

// @Composable-версия
@Composable
fun Gender.localizedName(): String = t(this.rawKey())