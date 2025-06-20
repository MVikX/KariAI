package app.kariai.composeapp.ui.screens.main.sections.assistantpanel
//TODO FAKE MESSAGES
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import app.kariai.composeapp.ui.screens.main.sections.assistantpanel.bubbles.AssistantMessageBubble
import app.kariai.composeapp.ui.screens.main.sections.assistantpanel.bubbles.UserMessageBubble
import app.kariai.composeapp.ui.screens.main.sections.assistantpanel.components.MessageInputField
import app.kariai.composeapp.ui.screens.main.sections.assistantpanel.components.SwipeDismissBox
import app.kariai.shared.presentation.main.assistentpanel.ChatMessage
import app.kariai.storage.nutrition.NutritionStats


@Composable
fun AssistantChatContent(
    nutritionStats: MutableState<NutritionStats>,
    onDismissRequest: () -> Unit
) {
    var inputText by remember { mutableStateOf("") }
    val messages = remember { mutableStateListOf<ChatMessage>() }
    val focusManager = LocalFocusManager.current
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Box(modifier = Modifier.weight(1f)) {
            SwipeDismissBox(onDismissRequest = onDismissRequest) {
                LazyColumn(
                    reverseLayout = true,
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(messages.size) { index ->
                        val message = messages.reversed()[index]

                        if (message.isUser) {
                            UserMessageBubble(text = message.text)
                        } else {
                            if (message.text == "TYPING") {
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
        }

        Spacer(modifier = Modifier.height(8.dp))

        MessageInputField(
            inputText = inputText,
            onInputTextChange = { inputText = it },
            onSendMessage = { message ->
                messages.add(ChatMessage(message, isUser = true))

                val typingMessage = ChatMessage("TYPING", isUser = false)
                messages.add(typingMessage)

                coroutineScope.launch {
                    delay(1500L)

                    messages.remove(typingMessage)

                    nutritionStats.value = nutritionStats.value.copy(
                        caloriesSpent = nutritionStats.value.caloriesSpent + 655,
                        carbs = nutritionStats.value.carbs + 94,
                        proteins = nutritionStats.value.proteins + 33,
                        fats = nutritionStats.value.fats + 15
                    )

                    val detailedResponse = """
                        Added based on your meal:
                        🍚 Rice: +300 kcal (70g carbs, 6g protein)
                        🦃 Turkey: +120 kcal (20g protein, 2g fat)
                        🥕 Carrot: +20 kcal (5g carbs)
                        🍄 Mushrooms: +15 kcal (2g protein)
                        🥣 Sour cream: +80 kcal (8g fat)
                        ☕ Coffee with milk and sugar: +120 kcal (15g carbs, 4g protein)

                        Total: +655 kcal, 33g protein, 94g carbs, 15g fat
                    """.trimIndent()

                    messages.add(
                        ChatMessage(
                            detailedResponse,
                            isUser = false
                        )
                    )
                }

                inputText = ""
                focusManager.clearFocus(force = true)
            }
        )
    }
}


@Composable
fun TypingIndicator() {
    var dotCount by remember { mutableStateOf(1) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(400L)
            dotCount = (dotCount % 3) + 1
        }
    }

    Text(
        text = ".".repeat(dotCount),
        style = MaterialTheme.typography.bodyMedium
    )
}











/*
@Composable
fun AssistantChatContent(
    onDismissRequest: () -> Unit,
    nutritionStats: MutableState<NutritionStats>,
) {
    var inputText by remember { mutableStateOf("") }
    val messages = remember { mutableStateListOf<ChatMessage>() }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Box(modifier = Modifier.weight(1f)) {
            SwipeDismissBox(onDismissRequest = onDismissRequest) {
                MessageList(messages = messages)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        MessageInputField(
            inputText = inputText,
            onInputTextChange = { inputText = it },
            onSendMessage = { message ->
                messages.add(ChatMessage(message, true))
                messages.add(ChatMessage("I'm thinking about it...", false))
                inputText = ""
                focusManager.clearFocus(force = true)
            }
        )
    }
}

 */