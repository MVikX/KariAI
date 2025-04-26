package org.example.kariai.ui.screens.main.widget.assistantpanel
//TODO нужно написать логику чата
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun AssistantBottomSheet(
    visible: Boolean,
    onDismiss: () -> Unit
) {
    // Анимация высоты
    val targetHeight = if (visible) 500.dp else 0.dp
    val animatedHeight by animateDpAsState(targetValue = targetHeight, label = "assistantHeight")

    if (visible || animatedHeight > 0.dp) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Полупрозрачный фон
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.9f))
                    .clickable { onDismiss() }
                    .zIndex(1f)
            )

            // Сам bottom sheet
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(animatedHeight)
                    .align(Alignment.BottomCenter)
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(16.dp)
                    .zIndex(2f),
                contentAlignment = Alignment.Center
            ) {
                Text("Чат ассистента", style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}