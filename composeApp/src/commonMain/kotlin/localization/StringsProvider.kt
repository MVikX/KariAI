package localization

interface StringsProvider {
    fun get(key: String): String
}