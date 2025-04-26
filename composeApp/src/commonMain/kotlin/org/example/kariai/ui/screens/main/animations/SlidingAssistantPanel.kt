package org.example.kariai.ui.screens.main.animations

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun SlidingAssistantPanel(
    isVisible: Boolean,
    onDismiss: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    val transition by animateFloatAsState(
        targetValue = if (isVisible) 0f else 1f,
        label = "slideAssistant"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = if (isVisible) 0.4f else 0f))
            .noRippleClickable(onDismiss)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.66f)
                .align(Alignment.BottomCenter)
                .offset { IntOffset(0, (transition * 1000).toInt()) }
                .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .padding(16.dp)
        ) {
            content()
        }
    }
}


fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier =
    pointerInput(Unit) {
        detectTapGestures(onTap = { onClick() })
    }