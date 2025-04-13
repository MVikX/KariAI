package org.example.nutriai.ui.screens.main.components.week
//TODO добавить логику нажатия
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WeekSummaryContainer (
   modifier: Modifier = Modifier,
   onClick: () -> Unit = {},
   content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.surface.copy(alpha = 1f),
                shape = RoundedCornerShape(12.dp),
            )
            .clickable { onClick() }
            .padding(12.dp)
    ) {
        content()
    }
}