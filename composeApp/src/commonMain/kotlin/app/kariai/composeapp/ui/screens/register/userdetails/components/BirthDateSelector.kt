package app.kariai.composeapp.ui.screens.register.userdetails.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.icerock.moko.resources.compose.painterResource
import app.kariai.shared.MR

@Composable
fun BirthDateSelector(
    day: Int,
    month: Int,
    year: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val displayDate = buildString {
        append(if (day < 10) "0$day" else "$day")
        append(".")
        append(if (month < 10) "0$month" else "$month")
        append(".")
        append(year)
    }

    Column {
        AnimatedBorderWrapper(
            modifier = modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { onClick() }
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(MR.images.calendar),
                    contentDescription = null,
                    modifier = Modifier
                        .height(40.dp)
                        .padding(end = 10.dp)
                )

                Text(
                    text = displayDate,
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}