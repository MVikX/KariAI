package app.kariai.composeapp.ui.screens.downmenu.components.water

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.kariai.composeapp.localization.t
import app.kariai.composeapp.ui.screens.downmenu.components.DownMenuBoxContainer

@Composable
fun WaterWidget () {
    DownMenuBoxContainer(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(t("down_menu.water"), style = MaterialTheme.typography.titleMedium)
        }
    }
}