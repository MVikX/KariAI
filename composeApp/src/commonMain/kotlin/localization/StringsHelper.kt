package localization

import androidx.compose.runtime.Composable

@Composable
fun t(key: String): String {
    return LocalStrings.current.get(key)
}