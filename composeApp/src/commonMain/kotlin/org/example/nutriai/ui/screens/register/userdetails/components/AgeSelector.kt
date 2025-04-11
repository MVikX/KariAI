package org.example.nutriai.ui.screens.register.userdetails.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import localization.t

@Composable
fun AgeSelector(
    age: Int,
    onAgeChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column (
        modifier = Modifier.fillMaxWidth()
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = t("profile.age"),
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 40.sp,
            )
        }

        Spacer(
            modifier = Modifier.height(8.dp),
        )


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "$age",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 24.sp
            )
        }

        Spacer(
            modifier = Modifier.height(1.dp),
        )


        Slider(
            value = age.toFloat(),
            onValueChange = {onAgeChange(it.toInt())},
            valueRange = 10f..100f
        )
    }
}