package app.kariai.composeapp.ui.screens.register.userdetails.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun AnimatedBorderWrapper( //TODO автоматизацию цвета сделать
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 28.dp,
    strokeWidth: Dp = 3.dp,
    content: @Composable BoxScope.() -> Unit
) {
    val orangeProgress = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        while (true) {
            orangeProgress.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 2000, easing = LinearEasing)
            )
            orangeProgress.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = 2000, easing = LinearEasing)
            )
            delay(100)
        }
    }

    Box(
        modifier = modifier
            .padding(2.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val strokePx = strokeWidth.toPx()
            val orangeEnd = orangeProgress.value
            val blendWidth = 0.05f

            drawRoundRect(
                brush = Brush.horizontalGradient(
                    colorStops = arrayOf(
                        0.0f to Color(0xFFFF9B00),
                        (orangeEnd - blendWidth).coerceIn(0f, 1f) to Color(0xFFFF9B00),
                        orangeEnd.coerceIn(0f, 1f) to Color(0xFF1AFFFF),
                        1.0f to Color(0xFF1AFFFF)
                    )
                ),
                cornerRadius = CornerRadius(cornerRadius.toPx()),
                style = Stroke(width = strokePx)
            )
        }

        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(cornerRadius))
                .background(Color(0xFF121212)),
            contentAlignment = Alignment.Center,
            content = content
        )
    }
}