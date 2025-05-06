package app.kariai.composeapp.ui.screens.register.userdetails.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.kariai.composeapp.localization.t
import app.kariai.shared.MR


@Composable
fun HeightSelector(
    height: Int,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val content = @Composable {
            MetricBox(
                value = "$height${t("profile.cm")}",
                onClick = onClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                image = MR.images.height,
                textKey = t("profile.height")
            )
        }

        if (height > 0) {
            AnimatedBorderWrapper(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                content()
            }
        } else {
            content()
        }
    }
}

@Composable
fun WeightSelector(
    weight: Double,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val content = @Composable {
            MetricBox(
                value = "$weight${t("profile.kg")}",
                onClick = onClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                image = MR.images.weight,
                textKey = t("profile.weight")
            )
        }

        if (weight > 0.0) {
            AnimatedBorderWrapper(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                content()
            }
        } else {
            content()
        }
    }
}