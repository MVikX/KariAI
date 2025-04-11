package org.example.nutriai.shared.domain.validation

object EmailValidator {
    fun isValid(email: String) : Boolean {
        return Regex ("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
            .matches(email.trim())
    }
}