package app.kariai.composeapp.localization

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LanguageViewModel {
    private val _strings = MutableStateFlow<StringsProvider?>(null)
    val strings: StateFlow<StringsProvider?> = _strings

    suspend fun loadStrings(languageCode: String = "en") {
        val yaml = loadYaml(languageCode)
        _strings.value = YamlStringsProvider.fromYamlText(yaml)
    }
}