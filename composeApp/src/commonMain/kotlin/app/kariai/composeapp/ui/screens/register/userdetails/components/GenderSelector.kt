package app.kariai.composeapp.ui.screens.register.userdetails.components

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
import app.kariai.composeapp.localization.t
import app.kariai.shared.presentation.auth.register.userdetails.enums.Gender

@Composable
fun GenderSelector (
    selectedGender: app.kariai.shared.presentation.auth.register.userdetails.enums.Gender?,
    onGenderSelected: (app.kariai.shared.presentation.auth.register.userdetails.enums.Gender) -> Unit
) {
    Column {
        Text(
            text = t("profile.gender_label"),
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 35.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 8.dp)
        )

        Row (
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            app.kariai.shared.presentation.auth.register.userdetails.enums.Gender.values().forEach { gender ->
                val isSelected = gender == selectedGender
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp)
                        .background(
                            color = if (isSelected) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.surface.copy(alpha = 1f),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .clickable { onGenderSelected(gender) },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = gender.localizedName(),
                        color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface,
                        fontSize = 30.sp
                    )
                }
            }
        }
    }
}