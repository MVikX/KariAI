package org.example.nutriai.ui.screens.main.components.week
//TODO сделать автоматизацию цвета + логика
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun MiniArcIndicator (
    modifier: Modifier = Modifier,
    spentProgress: Float, // от 0 до 1
    eatenProgress: Float, // от 0 до 1
    size: Float = 40f
) {
    Canvas (
        modifier = modifier.size(size.dp),
    ) {
        val strokeWidth = 4.dp.toPx()
        val diameter = size.dp.toPx()
        val arcSize = Size(diameter, diameter)


        //фон(прозрачный и серый круг)
        drawArc(
            color = Color.LightGray.copy(alpha = 0.3f),
            startAngle = 0f,
            sweepAngle = 360f,
            useCenter = false,
            style = Stroke(strokeWidth),
        )

        //съедено(синий)
        drawArc(
            color = Color(0xFF2196F3),
            startAngle = -90f,
            sweepAngle = 360f * eatenProgress.coerceIn(0f, 1f),
            useCenter = false,
            style = Stroke(strokeWidth)
        )


        //потрачено калорий(ораньжевый)
        drawArc(
            color = Color(0xFFFF9800),
            startAngle = -90f,
            sweepAngle = 360f * spentProgress.coerceIn(0f, 1f),
            useCenter = false,
            style = Stroke(strokeWidth / 2)
        )
    }
}