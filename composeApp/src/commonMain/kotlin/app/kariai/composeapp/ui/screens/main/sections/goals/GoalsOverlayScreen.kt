package app.kariai.composeapp.ui.screens.main.sections.goals

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.kariai.composeapp.resources.NutriTheme

@Composable
fun GoalsOverlayScreen(onClose: () -> Unit) {
    NutriTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "goals stub", //TODO stub ачивок
                    style = MaterialTheme.typography.headlineLarge,
                )
            }
        }
    }
}