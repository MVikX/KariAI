package org.example.nutriai.ui.screens.main.components.stats
//TODO ТРЕБУЕТ ЛОКАЛИЗАЦИИ + Базу + Логику
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatsGrid (
    modifier: Modifier = Modifier,
) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            StatBox(title = "Distance", value = "25 km", modifier = Modifier.weight(1f))
            StatBox(title = "Steps", value = "18 000", modifier = Modifier.weight(1f))
            StatBox(title = "Water", value = "2", modifier = Modifier.weight(1f))
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatBox(title = "Carbs", value = "105 g", modifier = Modifier.weight(1f))
            StatBox(title = "Protein", value = "25 g", modifier = Modifier.weight(1f))
            StatBox(title = "Fat", value = "62 g", modifier = Modifier.weight(1f))
        }
    }
}