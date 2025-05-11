package app.kariai.composeapp.ui.screens.main.components.week
//TODO добавить локализацию
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import app.kariai.composeapp.localization.t

@Composable
fun WeekCircleSummaryRow(
    spentList: List<Float>,
    eatenList: List<Float>,
    modifier: Modifier = Modifier,
    onClick: (Offset) -> Unit = {},
) {
    val days = listOf(
        t("week.mon_week"),
        t("week.tue_week"),
        t("week.wed_week"),
        t("week.thu_week"),
        t("week.fri_week"),
        t("week.sat_week"),
        t("week.sun_week"),
    )

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
                text = t("week.this_week"),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            // мини-кружки
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                days.indices.forEach { index ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        MiniArcIndicator(
                            spentProgress = spentList.getOrElse(index) { 0f },
                            eatenProgress = eatenList.getOrElse(index) { 0f },
                            dayLabel = days[index]
                        )
                    }
                }
            }
        }
    }
}