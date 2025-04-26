package org.example.kariai.ui.screens.main.widget.assistantpanel
//TODO нужна логика, автоцвет
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.example.kariai.resources.NutriTheme

@Composable
fun AssistantOverlayScreen(onClose: () -> Unit) {
    NutriTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1E1E1E)), // тёмный фон
            contentAlignment = Alignment.Center
        ) {
            Text("Assistant is thinking...", color = Color.White)
        }
    }
}