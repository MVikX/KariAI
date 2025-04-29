package app.kariai.composeapp.ui.screens.main.sections.assistantpanel
//TODO ФЕЙК СООБЩЕНИЯ
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import app.kariai.shared.presentation.main.NutritionStats



@Composable
fun AssistantOverlay(
    visible: Boolean,
    onDismiss: () -> Unit,
    nutritionStats: MutableState<app.kariai.shared.presentation.main.NutritionStats>,
) {
    val coroutineScope = rememberCoroutineScope()
    val targetHeight = if (visible) 540.dp else 0.dp
    val animatedHeight by animateDpAsState(targetValue = targetHeight, label = "assistantHeight")

    if (visible || animatedHeight > 0.dp) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        detectVerticalDragGestures { _, dragAmount ->
                            if (dragAmount > 100) {
                                coroutineScope.launch { onDismiss() }
                            }
                        }
                    }
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .background(Color.Black.copy(alpha = 0.5f))
                                .pointerInput(Unit) {
                                    detectVerticalDragGestures { _, dragAmount ->
                                        if (dragAmount > 100) {
                                            coroutineScope.launch { onDismiss() }
                                        }
                                    }
                                }
                                .clickable(
                                    indication = null,
                                    interactionSource = remember { MutableInteractionSource() }
                                ) {
                                    coroutineScope.launch { onDismiss() }
                                }
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(animatedHeight)
                                .background(MaterialTheme.colorScheme.surface)
                        ) {
                            AssistantChatContent(
                                nutritionStats = nutritionStats,
                                onDismissRequest = { coroutineScope.launch { onDismiss() } }
                            )
                        }
                    }
                }
            }
        }
    }
}





















/*
@Composable
fun AssistantOverlay(
    visible: Boolean,
    onDismiss: () -> Unit,
    nutritionStats: MutableState<NutritionStats>,
) {
    val coroutineScope = rememberCoroutineScope()
    val targetHeight = if (visible) 540.dp else 0.dp
    val animatedHeight by animateDpAsState(targetValue = targetHeight, label = "assistantHeight")

    if (visible || animatedHeight > 0.dp) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        detectVerticalDragGestures { _, dragAmount ->
                            if (dragAmount > 100) {
                                coroutineScope.launch { onDismiss() }
                            }
                        }
                    }
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        // верхняя полупрозрачная зона
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .background(Color.Black.copy(alpha = 0.5f))
                                .pointerInput(Unit) {
                                    detectVerticalDragGestures { _, dragAmount ->
                                        if (dragAmount > 100) {
                                            coroutineScope.launch { onDismiss() }
                                        }
                                    }
                                }
                                .clickable(
                                    indication = null,
                                    interactionSource = remember { MutableInteractionSource() }
                                ) {
                                    coroutineScope.launch { onDismiss() }
                                }
                        )

                        // нижний блок — чат
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(animatedHeight)
                                .background(MaterialTheme.colorScheme.surface)
                        ) {
                            AssistantChatContent(
                                nutritionStats = nutritionStats,
                                onDismissRequest = {
                                    coroutineScope.launch { onDismiss() }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

 */