package org.example.kariai.ui.screens.main.components.arc

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import kotlin.math.cos
import kotlin.math.sin


private fun Float.toRadians(): Float = ((this * kotlin.math.PI) / 180).toFloat()


fun DrawScope.drawInfinityArc(
    spentSweep: Float,
    burnedSweep: Float,
    fadeAngle: Float,
    maxArcAngle: Float,
    size: Size
) {

    val stroke = 70f
    val spacing = ArcSpacingPx
    val radius = (size.width - spacing) / 4f
    val centerSpacing = radius * 2f

    val leftCenter = Offset(size.width / 2 - centerSpacing / 2, size.height / 2)
    val rightCenter = Offset(size.width / 2 + centerSpacing / 2, size.height / 2)

    drawArcSegment(leftCenter, spentSweep, fadeAngle, radius, stroke, Color(0xFFFF9800), 0f)
    drawArcSegment(rightCenter, burnedSweep, fadeAngle, radius, stroke, Color(0xFF2196F3), 180f)
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
    if (sweep <= 0f) return

    if (sweep <= fadeAngle) {
        val angleEnd = baseStartAngle + sweep
        val start = arcPoint(center, radius, baseStartAngle)
        val end = arcPoint(center, radius, angleEnd)
        drawArc(
            brush = Brush.linearGradient(listOf(color, Color.Transparent), start, end),
            startAngle = baseStartAngle,
            sweepAngle = sweep,
            useCenter = false,
            topLeft = Offset(center.x - radius, center.y - radius),
            size = Size(radius * 2, radius * 2),
            style = Stroke(width = stroke, cap = StrokeCap.Round)
        )
    } else {
        drawArc(
            color = color,
            startAngle = baseStartAngle,
            sweepAngle = sweep - fadeAngle,
            useCenter = false,
            topLeft = Offset(center.x - radius, center.y - radius),
            size = Size(radius * 2, radius * 2),
            style = Stroke(width = stroke, cap = StrokeCap.Round)
        )

        val angleStart = baseStartAngle + sweep - fadeAngle
        val angleEnd = baseStartAngle + sweep
        val start = arcPoint(center, radius, angleStart)
        val end = arcPoint(center, radius, angleEnd)
        drawArc(
            brush = Brush.linearGradient(listOf(color, Color.Transparent), start, end),
            startAngle = angleStart,
            sweepAngle = fadeAngle,
            useCenter = false,
            topLeft = Offset(center.x - radius, center.y - radius),
            size = Size(radius * 2, radius * 2),
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