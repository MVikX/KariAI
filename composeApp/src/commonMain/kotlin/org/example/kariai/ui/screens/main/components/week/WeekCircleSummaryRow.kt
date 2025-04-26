package org.example.kariai.ui.screens.main.components.week
//TODO добавить локализацию
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp

@Composable
fun WeekCircleSummaryRow(
    spentList: List<Float>,
    eatenList: List<Float>,
    modifier: Modifier = Modifier,
    onClick: (Offset) -> Unit = {},
) {
    val days = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun") //TODO нужна локализация

    WeekSummaryContainer(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            // заголовок
            Text(
                text = "This Week", // TODO: локализация
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            // мини-кружки
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                days.indices.forEach { index ->
                    Column(horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally) {
                        MiniArcIndicator(
                            spentProgress = spentList.getOrElse(index) { 0f },
                            eatenProgress = eatenList.getOrElse(index) { 0f }
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = days[index], // TODO: локализация
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                        )
                    }
                }
            }
        }
    }
}