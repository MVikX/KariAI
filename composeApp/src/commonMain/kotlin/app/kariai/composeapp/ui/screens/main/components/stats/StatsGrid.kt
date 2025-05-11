package app.kariai.composeapp.ui.screens.main.components.stats
//TODO ТРЕБУЕТ ЛОКАЛИЗАЦИИ + Базу + Логику
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import app.kariai.shared.MR
import app.kariai.composeapp.localization.t
import app.kariai.composeapp.ui.screens.main.components.stats.components.toStyledKcalString
import app.kariai.storage.nutrition.NutritionStats


@Composable
fun StatsGrid (
    stats: NutritionStats,
    modifier: Modifier = Modifier,
    onDistanceClick: (Offset) -> Unit,
    onStepsClick: (Offset) -> Unit,
    onGoalsClick: (Offset) -> Unit,
    onCarbsClick: (Offset) -> Unit,
    onProteinClick: (Offset) -> Unit,
    onFatClick: (Offset) -> Unit,
) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            StatBox(
                title = t("stats.distance"),
                value = "${stats.distanceKm} " + t("small_all_wards.km"),
                modifier = Modifier.weight(1f),
                onClick = onDistanceClick,
                image = MR.images.distance,
            )

            StatBox(
                title = t("stats.activity"),
                value = toStyledKcalString(
                    stats.activityKcal,
                    t("small_all_wards.kcal")
                ),
                modifier = Modifier.weight(1f),
                onClick = onStepsClick,
                image = MR.images.activity
            )

            StatBox(
                title = t("stats.goals"),
                value = "2",
                modifier = Modifier.weight(1f),
                onClick = onGoalsClick,
                image = MR.images.goals,
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            StatBox(
                title = t("stats.carbs"),
                value = "${stats.carbs} g",
                modifier = Modifier.weight(1f),
                onClick = onCarbsClick,
                image = MR.images.carbs,
            )

            StatBox(
                title = t("stats.protein"),
                value = "${stats.proteins} g",
                modifier = Modifier.weight(1f),
                onClick = onProteinClick,
                image = MR.images.protein,
            )

            StatBox(
                title = t("stats.fat"),
                value = "${stats.fats} g",
                modifier = Modifier.weight(1f),
                onClick = onFatClick,
                image = MR.images.fat,
            )
        }
    }
}