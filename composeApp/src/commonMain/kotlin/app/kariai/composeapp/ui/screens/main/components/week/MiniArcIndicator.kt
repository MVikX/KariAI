package app.kariai.composeapp.ui.screens.main.components.week
//TODO implement color automation + logic
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

// sizes
private const val DefaultIndicatorSize = 40f
private val ArcStrokeWidth = 4.dp

// angles
private const val FullCircleAngle = 360f
private const val StartAngle = -90f
private const val ZeroFloat = 0f

// colors
private val SpentColor = Color(0xFFFF9800)
private val EatenColor = Color(0xFF2196F3)
private val BackgroundArcColor = Color.LightGray.copy(alpha = 0.3f)
private const val LabelTextAlpha = 0.85f

@Composable
fun MiniArcIndicator(
    modifier: Modifier = Modifier,
    spentProgress: Float, // from 0 to 1
    eatenProgress: Float, // from 0 to 1
    dayLabel: String,
    size: Float = DefaultIndicatorSize
) {
    Box(
        modifier = modifier.size(size.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val strokeWidthPx = ArcStrokeWidth.toPx()
            val diameter = size.dp.toPx()
            val arcSize = Size(diameter, diameter)

            val total = spentProgress + eatenProgress
            val spent = if (total > ZeroFloat) spentProgress / total else 0f
            val eaten = if (total > ZeroFloat) eatenProgress / total else 0f

            val spentAngle = spent * FullCircleAngle
            val eatenAngle = eaten * FullCircleAngle

            // background
            drawArc(
                color = BackgroundArcColor,
                startAngle = ZeroFloat,
                sweepAngle = FullCircleAngle,
                useCenter = false,
                style = Stroke(strokeWidthPx)
            )

            // spent (blue)
            drawArc(
                color = SpentColor,
                startAngle = StartAngle - spentAngle,
                sweepAngle = spentAngle,
                useCenter = false,
                style = Stroke(strokeWidthPx)
            )

            // eaten (orange)
            drawArc(
                color = EatenColor,
                startAngle = StartAngle,
                sweepAngle = eatenAngle,
                useCenter = false,
                style = Stroke(strokeWidthPx)
            )
        }

        Text(
            text = dayLabel,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = LabelTextAlpha)
        )
    }
}