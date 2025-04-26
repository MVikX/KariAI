package org.example.kariai.ui.components.common.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GradientButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    height: Dp = 50.dp,
    shape: Shape = RoundedCornerShape(16.dp),
    textColor: Color = Color.White,
    fontSize: TextUnit = 16.sp,
) {
    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF7F00FF),
            Color(0xFFE100FF)
        )
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .height(height)
            .background(
                brush = gradientBrush,
                shape = shape
                )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = fontSize,
            color = textColor,
            fontWeight = FontWeight.SemiBold
        )
    }
}