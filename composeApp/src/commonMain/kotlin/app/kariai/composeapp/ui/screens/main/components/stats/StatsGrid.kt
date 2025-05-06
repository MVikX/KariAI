package app.kariai.composeapp.ui.screens.main.components.stats
//TODO ТРЕБУЕТ ЛОКАЛИЗАЦИИ + Базу + Логику
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import app.kariai.shared.MR
import app.kariai.shared.presentation.main.NutritionStats

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
                title = "Distance",
                value = "25 km",
                modifier = Modifier.weight(1f),
                onClick = onDistanceClick,
                image = MR.images.distance,
            )

            StatBox(
                title = "Steps",
                value = "18 000",
                modifier = Modifier.weight(1f),
                onClick = onStepsClick,
                image = MR.images.steps
            )

            StatBox(
                title = "Goals",
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
                title = "Carbs",
                value = "${stats.carbs} g",
                modifier = Modifier.weight(1f),
                onClick = onCarbsClick,
                image = MR.images.carbs,
            )

            StatBox(
                title = "Protein",
                value = "${stats.proteins} g",
                modifier = Modifier.weight(1f),
                onClick = onProteinClick,
                image = MR.images.protein,
            )

            StatBox(
                title = "Fat",
                value = "${stats.fats} g",
                modifier = Modifier.weight(1f),
                onClick = onFatClick,
                image = MR.images.fat,
            )
        }
    }
}