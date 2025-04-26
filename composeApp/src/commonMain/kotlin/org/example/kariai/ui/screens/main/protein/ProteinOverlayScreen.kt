package org.example.kariai.ui.screens.main.protein

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.example.kariai.resources.NutriTheme

@Composable
fun ProteinOverlayScreen(onClose: () -> Unit) {
    NutriTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "протеин заглушка", //TODO заглушка протеина
                    style = MaterialTheme.typography.headlineLarge
                )
            }
        }
    }
}