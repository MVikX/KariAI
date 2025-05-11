package app.kariai.composeapp.ui.screens.main.components.week
//TODO сделать автоматизацию цвета + логика
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun MiniArcIndicator(
    modifier: Modifier = Modifier,
    spentProgress: Float, // от 0 до 1
    eatenProgress: Float, // от 0 до 1
    dayLabel: String, // ← добавили день недели
    size: Float = 40f
) {
    Box(
        modifier = modifier.size(size.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val strokeWidth = 4.dp.toPx()
            val diameter = size.dp.toPx()
            val arcSize = Size(diameter, diameter)

            val total = spentProgress + eatenProgress
            val spent = if (total > 0f) spentProgress / total else 0f
            val eaten = if (total > 0f) eatenProgress / total else 0f

            val startAngle = -90f
            val spentAngle = spent * 360f
            val eatenAngle = eaten * 360f

            // фон
            drawArc(
                color = Color.LightGray.copy(alpha = 0.3f),
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(strokeWidth)
            )

            // потрачено (оранжевый)
            drawArc(
                color = Color(0xFFFF9800),
                startAngle = startAngle - spentAngle,
                sweepAngle = spentAngle,
                useCenter = false,
                style = Stroke(strokeWidth)
            )

            // съедено (синий)
            drawArc(
                color = Color(0xFF2196F3),
                startAngle = startAngle,
                sweepAngle = eatenAngle,
                useCenter = false,
                style = Stroke(strokeWidth)
            )
        }

        // текст внутри круга
        Text(
            text = dayLabel,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.85f)
        )
    }
}