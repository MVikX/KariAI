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
import app.kariai.composeapp.localization.t
import app.kariai.shared.MR
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun NameInput(
    name: String,
    onClick: () -> Unit,
) {
    val hasName = name.isNotBlank()

    val content = @Composable {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clickable { onClick() }
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(MR.images.name),
                    contentDescription = null,
                    modifier = Modifier
                        .height(40.dp)
                        .padding(end = 10.dp)
                )

                Text(
                    text = if (hasName) name else t("profile.name_placeholder"),
                    fontSize = 40.sp,
                    color = if (hasName) MaterialTheme.colorScheme.onSurface else Color.Gray
                )
            }
        }
    }

    if (hasName) {
        AnimatedBorderWrapper(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            content()
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(
                    color = MaterialTheme.colorScheme.surface.copy(alpha = 1f),
                    shape = RoundedCornerShape(12.dp),
                ),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}