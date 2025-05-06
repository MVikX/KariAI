package app.kariai.composeapp.ui.screens.register.userdetails.components

import androidx.compose.foundation.Image
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
import app.kariai.shared.presentation.auth.register.userdetails.enums.Gender
import app.kariai.shared.MR
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun GenderSelector(
    selectedGender: Gender?,
    onGenderSelected: (Gender) -> Unit
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Gender.values().forEach { gender ->
                val isSelected = gender == selectedGender
                val image = when (gender) {
                    Gender.MALE -> MR.images.man
                    Gender.FEMALE -> MR.images.girls
                }

                val content: @Composable BoxScope.() -> Unit = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable { onGenderSelected(gender) }
                            .padding(horizontal = 16.dp)
                    ) {
                        Image(
                            painter = painterResource(image),
                            contentDescription = null,
                            modifier = Modifier
                                .height(40.dp)
                                .padding(end = 10.dp)
                        )

                        Text(
                            text = gender.localizedName(),
                            color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface,
                            fontSize = 28.sp
                        )
                    }
                }

                if (isSelected) {
                    AnimatedBorderWrapper(
                        modifier = Modifier
                            .weight(1f)
                            .height(60.dp)
                    ) {
                        content()
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(60.dp)
                            .background(
                                color = MaterialTheme.colorScheme.surface.copy(alpha = 1f),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .clickable { onGenderSelected(gender) },
                        contentAlignment = Alignment.Center
                    ) {
                        content()
                    }
                }
            }
        }
    }
}