package org.example.kariai.ui.screens.main.components.stats
//TODO ТРЕБУЕТ ЛОКАЛИЗАЦИИ + Базу + Логику
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp

@Composable
fun StatsGrid (
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
                onClick = onDistanceClick
            )

            StatBox(
                title = "Steps",
                value = "18 000",
                modifier = Modifier.weight(1f),
                onClick = onStepsClick
            )

            StatBox(
                title = "Goals",
                value = "2",
                modifier = Modifier.weight(1f),
                onClick = onGoalsClick
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            StatBox(
                title = "Carbs",
                value = "105 g",
                modifier = Modifier.weight(1f),
                onClick = onCarbsClick
            )

            StatBox(
                title = "Protein",
                value = "25 g",
                modifier = Modifier.weight(1f),
                onClick = onProteinClick
            )

            StatBox(
                title = "Fat",
                value = "62 g",
                modifier = Modifier.weight(1f),
                onClick = onFatClick
            )
        }
    }
}