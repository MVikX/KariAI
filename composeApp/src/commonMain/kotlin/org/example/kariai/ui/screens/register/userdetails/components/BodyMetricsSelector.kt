package org.example.kariai.ui.screens.register.userdetails.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import localization.t

@Composable
fun BodyMetricsSelector(
    height: Int,
    weight: Double,
    onHeightClick: () -> Unit,
    onWeightClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = t("profile.height"),
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 35.sp,
            )
            Spacer(modifier = Modifier.height(8.dp))
            MetricBox(
                value = "$height" + t("profile.cm"),
                onClick = onHeightClick,
                modifier = Modifier.fillMaxWidth().height(60.dp)
            )
        }

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = t("profile.weight"),
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 35.sp,
            )
            Spacer(modifier = Modifier.height(8.dp))
            MetricBox(
                value = "$weight" + t("profile.kg"),
                onClick = onWeightClick,
                modifier = Modifier.fillMaxWidth().height(60.dp)
            )
        }
    }
}