package org.example.nutriai.shared.presentation.auth.register.userdetails

import org.example.nutriai.shared.presentation.auth.register.userdetails.enums.Gender

data class UserDetailsUiState(
    val age: Int = 25,
    val height: Int = 175,
    val weight: Double = 75.5,
    val gender: Gender? = null,
    val allergies: String = "",
    val intolerances: String = ""
)