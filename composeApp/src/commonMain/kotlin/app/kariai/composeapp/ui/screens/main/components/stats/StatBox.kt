package app.kariai.composeapp.ui.screens.main.components.stats

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.compose.painterResource

// dimensions
private val IconHeight = 40.dp
private val SpacerHeight = 10.dp

// visual
private const val SubtitleAlpha = 0.7f

@Composable
fun StatBox(
    title: String,
    value: Any,
    modifier: Modifier = Modifier,
    onClick: (Offset) -> Unit = {},
    image: ImageResource? = null,
) {
    val renderedValue = when (value) {
        is AnnotatedString -> value
        is String -> buildAnnotatedString { append(value) }
        else -> buildAnnotatedString { append(value.toString()) }
    }

    StatBoxContainer(
        modifier = modifier,
        onClick = onClick,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            if (image != null) {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier.height(IconHeight)
                )
            }

            Spacer(modifier = Modifier.height(SpacerHeight))

            Text(
                text = renderedValue,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                softWrap = false,
                maxLines = 1
            )

            Text(
                text = title,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = SubtitleAlpha),
                textAlign = TextAlign.Center,
            )
        }
    }
}