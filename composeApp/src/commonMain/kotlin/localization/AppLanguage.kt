package localization

enum class AppLanguage(val code: String) {
    EN("en"),
    RU("ru");

    companion object {
        fun from(code: String): AppLanguage =
            values().find { it.code == code } ?: EN
    }
}