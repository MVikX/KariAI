package app.kariai.composeapp.ui.screens.main.components.arc
//TODO add color to themes
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import kotlin.math.cos
import kotlin.math.sin

// arc drawing constants
private const val ArcStrokeWidth = 70f
private const val ArcRadiusDivider = 4f
private const val ArcCenterSpacingMultiplier = 2f
private const val ArcLeftStartAngle = 0f
private const val ArcRightStartAngle = 180f
private const val SweepMinimumThreshold = 0f
private const val ArcPositionDivider = 2 //???

private val SpentColor = Color(0xFFFF9800)
private val BurnedColor = Color(0xFF2196F3)
private val TransparentColor = Color.Transparent

private fun Float.toRadians(): Float = ((this * kotlin.math.PI) / 180).toFloat()


fun DrawScope.drawInfinityArc(
    spentSweep: Float,
    burnedSweep: Float,
    fadeAngle: Float,
    maxArcAngle: Float,
    size: Size
) {

    val stroke = ArcStrokeWidth
    val spacing = ArcSpacingPx
    val radius = (size.width - spacing) / ArcRadiusDivider
    val centerSpacing = radius * ArcCenterSpacingMultiplier

    val leftCenter = Offset(
        size.width / ArcPositionDivider - centerSpacing / ArcPositionDivider,
        size.height / ArcPositionDivider
    )
    val rightCenter = Offset(
        size.width / ArcPositionDivider + centerSpacing / ArcPositionDivider,
        size.height / ArcPositionDivider)

    drawArcSegment(leftCenter, spentSweep, fadeAngle, radius, stroke, SpentColor, ArcLeftStartAngle)
    drawArcSegment(rightCenter, burnedSweep, fadeAngle, radius, stroke, BurnedColor, ArcRightStartAngle)
}

private fun DrawScope.drawArcSegment(
    center: Offset,
    sweep: Float,
    fadeAngle: Float,
    radius: Float,
    stroke: Float,
    color: Color,
    baseStartAngle: Float
) {
    if (sweep <= SweepMinimumThreshold) return

    if (sweep <= fadeAngle) {
        val angleEnd = baseStartAngle + sweep
        val start = arcPoint(center, radius, baseStartAngle)
        val end = arcPoint(center, radius, angleEnd)
        drawArc(
            brush = Brush.linearGradient(listOf(color, TransparentColor), start, end),
            startAngle = baseStartAngle,
            sweepAngle = sweep,
            useCenter = false,
            topLeft = Offset(center.x - radius, center.y - radius),
            size = Size(radius * ArcPositionDivider, radius * ArcPositionDivider),
            style = Stroke(width = stroke, cap = StrokeCap.Round)
        )
    } else {
        drawArc(
            color = color,
            startAngle = baseStartAngle,
            sweepAngle = sweep - fadeAngle,
            useCenter = false,
            topLeft = Offset(center.x - radius, center.y - radius),
            size = Size(radius * ArcPositionDivider, radius * ArcPositionDivider),
            style = Stroke(width = stroke, cap = StrokeCap.Round)
        )

        val angleStart = baseStartAngle + sweep - fadeAngle
        val angleEnd = baseStartAngle + sweep
        val start = arcPoint(center, radius, angleStart)
        val end = arcPoint(center, radius, angleEnd)
        drawArc(
            brush = Brush.linearGradient(listOf(color, TransparentColor), start, end),
            startAngle = angleStart,
            sweepAngle = fadeAngle,
            useCenter = false,
            topLeft = Offset(center.x - radius, center.y - radius),
            size = Size(radius * ArcPositionDivider, radius * ArcPositionDivider),
            style = Stroke(width = stroke, cap = StrokeCap.Butt)
        )
    }
}

private fun arcPoint(center: Offset, radius: Float, angle: Float): Offset {
    val rad = angle.toRadians()
    return Offset(
        center.x + radius * cos(rad),
        center.y + radius * sin(rad)
    )
}