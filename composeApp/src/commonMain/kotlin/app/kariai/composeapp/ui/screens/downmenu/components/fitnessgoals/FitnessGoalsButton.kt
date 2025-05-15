package app.kariai.composeapp.ui.screens.downmenu.components.fitnessgoals

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.kariai.composeapp.localization.t
import app.kariai.composeapp.ui.screens.downmenu.components.DownMenuBoxContainer
import app.kariai.shared.MR

@Composable
fun FitnessGoalsButton () {
    DownMenuBoxContainer(
        modifier = Modifier.fillMaxWidth(),
        image = MR.images.fitnesgoals_icons_menu
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(t("down_menu.fitness_goals"), style = MaterialTheme.typography.titleMedium)
        }
    }
}