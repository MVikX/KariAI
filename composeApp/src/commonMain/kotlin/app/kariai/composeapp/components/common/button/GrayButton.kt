package app.kariai.composeapp.components.common.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// sizes and corner radius
private val GrayButtonHeight = 52.dp
private val GrayButtonCornerRadius = 14.dp

// alpha and styles
private const val GrayButtonBackgroundAlpha = 0.1f
private const val GrayButtonTextAlpha = 0.5f
private val GrayButtonFontSize = 16.sp

@Composable
fun GrayButton(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(GrayButtonHeight)
            .background(
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = GrayButtonBackgroundAlpha),
                shape = RoundedCornerShape(GrayButtonCornerRadius),
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = GrayButtonFontSize,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = GrayButtonTextAlpha)
        )
    }
}