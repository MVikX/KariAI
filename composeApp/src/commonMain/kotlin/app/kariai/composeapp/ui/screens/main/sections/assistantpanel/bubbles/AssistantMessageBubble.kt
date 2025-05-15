package app.kariai.composeapp.ui.screens.main.sections.assistantpanel.bubbles

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// style values
private val BubbleCornerRadius = 16.dp
private val BubbleElevation = 2.dp
private val HorizontalPadding = 8.dp
private val InnerPadding = 12.dp

@Composable
fun AssistantMessageBubble(
    text: String? = null,
    content: @Composable (() -> Unit)? = null
) {
    Surface(
        shape = RoundedCornerShape(BubbleCornerRadius),
        tonalElevation = BubbleElevation,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = HorizontalPadding)
    ) {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier.padding(InnerPadding)
        ) {
            if (content != null) {
                content()
            } else if (text != null) {
                Text(text)
            }
        }
    }
}












/*
@Composable
fun AssistantMessageBubble(text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(
                text = text,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

 */