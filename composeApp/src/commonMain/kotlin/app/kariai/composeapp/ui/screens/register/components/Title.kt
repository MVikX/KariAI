package app.kariai.composeapp.ui.screens.register.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import app.kariai.composeapp.localization.t

@Composable
fun Title() {
    Text(
        text = t("auth.sign_up"),
        style = MaterialTheme.typography.headlineMedium.copy(
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        ),
        color = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier
    )
}