package app.kariai.composeapp.localization

import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.readResourceBytes

@OptIn(InternalResourceApi::class)
actual suspend fun loadYaml(language: String): String {
    val fileName = "strings/strings_${language}.yaml"
    val bytes = readResourceBytes(fileName)
    return bytes.decodeToString()
}