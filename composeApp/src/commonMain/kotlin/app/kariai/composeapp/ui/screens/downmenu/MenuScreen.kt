package app.kariai.composeapp.ui.screens.downmenu

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.kariai.composeapp.ui.screens.downmenu.components.fitnessgoals.FitnessGoalsButton
import app.kariai.composeapp.ui.screens.downmenu.components.infoapp.InfoAppButton
import app.kariai.composeapp.ui.screens.downmenu.components.notifications.NotificationsButton
import app.kariai.composeapp.ui.screens.downmenu.components.premium.PremiumButton
import app.kariai.composeapp.ui.screens.downmenu.components.profile.ProfileButton
import app.kariai.composeapp.ui.screens.downmenu.components.settings.SettingsButton
import app.kariai.composeapp.ui.screens.downmenu.components.water.WaterWidget

private val MenuHorizontalPadding = 32.dp
private val MenuSpacer = 10.dp

@Composable
fun MenuScreen () {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = MenuHorizontalPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PremiumButton()
        Spacer(modifier = Modifier.height(MenuSpacer))

        ProfileButton()
        Spacer(modifier = Modifier.height(MenuSpacer))

        SettingsButton()
        Spacer(modifier = Modifier.height(MenuSpacer))

        FitnessGoalsButton()
        Spacer(modifier = Modifier.height(MenuSpacer))

        NotificationsButton()
        Spacer(modifier = Modifier.height(MenuSpacer))

        InfoAppButton()
        Spacer(modifier = Modifier.height(MenuSpacer))

        WaterWidget()
    }
}