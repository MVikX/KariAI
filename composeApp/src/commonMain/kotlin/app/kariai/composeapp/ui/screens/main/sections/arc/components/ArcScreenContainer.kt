package app.kariai.composeapp.ui.screens.main.sections.arc.components
//TODO требует корратировки цвета, добовление автоцвета
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ArcScreenContainer(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {

    Box(
        modifier = modifier
            .background(
                color = Color(0xFF2C2C2E),
                shape = RoundedCornerShape(12.dp),
            )
            .border(
                width = 1.dp,
                color = Color.DarkGray.copy(alpha = 0.3f),
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        content()
    }
}