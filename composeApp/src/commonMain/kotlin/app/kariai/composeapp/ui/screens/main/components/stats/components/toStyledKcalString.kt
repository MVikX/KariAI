package app.kariai.composeapp.ui.screens.main.components.stats.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import kotlin.math.roundToInt

@Composable
fun toStyledKcalString(value: Double, unit: String): AnnotatedString {
    val rounded = value.roundToInt()

    val formattedValue = if (rounded >= 1000) {
        val inK = (value / 1000 * 10).roundToInt() / 10.0
        "${inK}k"
    } else {
        rounded.toString()
    }

    val baseStyle = MaterialTheme.typography.bodyLarge

    val unitFontSize = if (rounded >= 100) {
        TextUnit(12f, TextUnitType.Sp)
    } else {
        baseStyle.fontSize
    }

    return buildAnnotatedString {
        append(formattedValue)
        append(" ")

        pushStyle(
            SpanStyle(
                fontSize = unitFontSize,
                fontFamily = baseStyle.fontFamily,
                fontWeight = baseStyle.fontWeight,
                letterSpacing = baseStyle.letterSpacing
            )
        )
        append(unit)
        pop()
    }
}