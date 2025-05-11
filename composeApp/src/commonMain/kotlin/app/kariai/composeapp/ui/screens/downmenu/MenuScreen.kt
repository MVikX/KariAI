package app.kariai.composeapp.ui.screens.downmenu

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.kariai.composeapp.ui.screens.downmenu.components.infoapp.InfoAppButton
import app.kariai.composeapp.ui.screens.downmenu.components.notifications.NotificationsButton
import app.kariai.composeapp.ui.screens.downmenu.components.premium.PremiumButton
import app.kariai.composeapp.ui.screens.downmenu.components.profile.ProfileButton
import app.kariai.composeapp.ui.screens.downmenu.components.purposes.PurposesButton
import app.kariai.composeapp.ui.screens.downmenu.components.settings.SettingsButton
import app.kariai.composeapp.ui.screens.downmenu.components.water.WaterWidget

@Composable
fun MenuScreen () {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val spacer = 10.dp


        PremiumButton()

        Spacer(modifier = Modifier.height(spacer))

        ProfileButton()

        Spacer(modifier = Modifier.height(spacer))

        SettingsButton()

        Spacer(modifier = Modifier.height(spacer))

        PurposesButton()

        Spacer(modifier = Modifier.height(spacer))

        NotificationsButton()

        Spacer(modifier = Modifier.height(spacer))

        InfoAppButton()

        Spacer(modifier = Modifier.height(spacer))

        WaterWidget()
    }
}