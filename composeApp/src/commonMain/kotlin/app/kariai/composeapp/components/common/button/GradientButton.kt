package app.kariai.composeapp.components.common.button
//TODO add color to theme
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

// style
private val GradientStartColor = Color(0xFF7F00FF)
private val GradientEndColor = Color(0xFFE100FF)

// default sizes and style
private val DefaultButtonHeight = 50.dp
private val DefaultCornerRadius = 16.dp
private val DefaultFontSize = 16.sp
private val DefaultTextColor = Color.White

@Composable
fun GradientButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    height: Dp = DefaultButtonHeight,
    shape: Shape = RoundedCornerShape(DefaultCornerRadius),
    textColor: Color = DefaultTextColor,
    fontSize: TextUnit = DefaultFontSize,
) {
    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(GradientStartColor, GradientEndColor)
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