package org.example.nutriai.ui.screens.register.userdetails.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import localization.t

@Composable
fun BirthDateSelector (
    day: Int,
    month: Int,
    year: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val hasDate = day > 0 && month > 0 && year > 0


    val displayDate = if (hasDate) {
        buildString {
            append(if (day < 10) "0$day" else "$day")
            append(".")
            append(if (month < 10) "0$month" else "$month")
            append(".")
            append(year)
        }
    } else {
        t("profile.select_birthdate")
    }

    Column {
        Text(
            text = t("profile.birthdate_label"),
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 35.sp,
            modifier = Modifier.padding(bottom = 8.dp),
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
            Text(
                text = displayDate,
                fontSize = 26.sp,
                color = if (hasDate) MaterialTheme.colorScheme.onSurface else Color.Gray
            )
        }
    }
}