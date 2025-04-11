package org.example.nutriai.shared.domain.validation

object PasswordValidator {
    private val commonPasswords = setOf(
        "123456", "12345678", "123123", "password", "qwerty",
        "admin", "111111", "abc123", "letmein", "000000", "123321"
    )


    fun isStrong (password: String): Boolean {
        if (password.length <8) return false
        if (password.lowercase() in commonPasswords) return false
        if (!password.any {it.isDigit()}) return false
        if (!password.any {it.isLetter()}) return false
        return true
    }
}