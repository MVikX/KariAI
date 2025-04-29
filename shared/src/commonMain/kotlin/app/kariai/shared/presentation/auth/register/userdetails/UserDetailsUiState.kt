package app.kariai.shared.presentation.auth.register.userdetails

import app.kariai.shared.presentation.auth.register.userdetails.enums.Gender

data class UserDetailsUiState(
    val userName: String = "",
    val birthDay: Int = 17,
    val birthMonth: Int = 10,
    val birthYear: Int = 2000,
    val height: Int = 175,
    val weight: Double = 75.5,
    val gender: app.kariai.shared.presentation.auth.register.userdetails.enums.Gender? = null,
    val allergies: String = "",
    val intolerances: String = "",
)