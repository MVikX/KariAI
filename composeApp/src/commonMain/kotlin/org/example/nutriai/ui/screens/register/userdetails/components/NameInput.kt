package org.example.nutriai.ui.screens.register.userdetails.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import localization.t

@Composable
fun NameInput(
    name: String,
    onClick: () -> Unit,
) {
    Column {
        Text(
            text = t("profile.name_label"),
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 35.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 8.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(
                    color = MaterialTheme.colorScheme.surface.copy(alpha = 1f),
                    shape = RoundedCornerShape(12.dp),
                )
                .clickable { onClick() }
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            val hasName = name.isNotBlank()
            Text(
                text = if (hasName) name else t("profile.name_placeholder"),
                fontSize = 30.sp,
                color = if (hasName) MaterialTheme.colorScheme.onSurface else Color.Gray
            )
        }
    }
}