package app.kariai.composeapp.ui.screens.login.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.kariai.composeapp.localization.t
import app.kariai.shared.MR
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun Title() {
    val transition = rememberInfiniteTransition()

    val floatY by transition.animateFloat(
        initialValue = -138f,
        targetValue = -148f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val rotation by transition.animateFloat(
        initialValue = -3f,
        targetValue = 3f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = "KariAI",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 80.sp,
                lineHeight = 44.sp
            )
        )

        Spacer(modifier = Modifier.height(42.dp))

        Box(
            modifier = Modifier.height(200.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            // Анимированный робот
            Image(
                painter = painterResource(MR.images.kariai_robot),
                contentDescription = null,
                modifier = Modifier
                    .height(90.dp)
                    .offset(y = floatY.dp + 6.dp)
                    .graphicsLayer {
                        rotationZ = rotation
                    }
            )

            // Логотип
            Image(
                painter = painterResource(MR.images.main_logo),
                contentDescription = null,
                modifier = Modifier.height(200.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = t("home.hello"),
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp,
                lineHeight = 44.sp
            ),
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = t("home.hello_in_down"),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                lineHeight = 24.sp
            ),
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
        )
    }
}