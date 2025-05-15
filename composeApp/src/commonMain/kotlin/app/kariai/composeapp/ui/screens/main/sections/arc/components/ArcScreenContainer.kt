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

// style
private val ContainerCornerRadius = 12.dp
private val BorderWidth = 1.dp

// colors
private val ContainerBackgroundColor = Color(0xFF2C2C2E)
private val BorderColor = Color.DarkGray.copy(alpha = 0.3f)

@Composable
fun ArcScreenContainer(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {

    Box(
        modifier = modifier
            .background(
                color = ContainerBackgroundColor,
                shape = RoundedCornerShape(ContainerCornerRadius),
            )
            .border(
                width = BorderWidth,
                color = BorderColor,
                shape = RoundedCornerShape(ContainerCornerRadius)
            )
    ) {
        content()
    }
}