package app.kariai.composeapp.ui.screens.main.sections.assistantpanel.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.kariai.shared.presentation.main.assistentpanel.ChatMessage
import app.kariai.composeapp.ui.screens.main.sections.assistantpanel.TypingIndicator
import app.kariai.composeapp.ui.screens.main.sections.assistantpanel.bubbles.AssistantMessageBubble
import app.kariai.composeapp.ui.screens.main.sections.assistantpanel.bubbles.UserMessageBubble

@Composable
fun MessageList(messages: List<ChatMessage>) {
    LazyColumn(
        reverseLayout = true,
        modifier = Modifier.fillMaxSize()
    ) {
        items(messages.reversed()) { message ->
            if (message.isUser) {
                UserMessageBubble(text = message.text)
            } else {
                if (message.text == "TYPING") {
                    // анимация точек
                    AssistantMessageBubble {
                        TypingIndicator()
                    }
                } else {
                    AssistantMessageBubble(text = message.text)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

















/*
@Composable
fun MessageList(messages: List<ChatMessage>) {
    LazyColumn(
        reverseLayout = true,
        modifier = Modifier.fillMaxSize()
    ) {
        items(messages.reversed()) { message ->
            if (message.isUser) {
                UserMessageBubble(text = message.text)
            } else {
                AssistantMessageBubble(text = message.text)
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

 */