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

// animation values
private const val FloatYInitial = -138f
private const val FloatYTarget = -148f
private const val RotationStart = -3f
private const val RotationEnd = 3f
private const val FloatYOffsetAdjustment = 6

private const val FloatYDuration = 1500
private const val RotationDuration = 2000

// sizes and spacing
private val HorizontalPadding = 16.dp
private val LogoFontSize = 80.sp
private val LogoLineHeight = 44.sp
private val LogoSpacerHeight = 42.dp
private val BoxHeight = 200.dp
private val RobotHeight = 90.dp
private val BelowBoxSpacer = 30.dp
private val HelloFontSize = 30.sp
private val HelloLineHeight = 44.sp
private val SubTextSpacer = 8.dp
private val SubTextFontSize = 18.sp
private val SubTextLineHeight = 24.sp
private const val SubTextAlpha = 0.7f

@Composable
fun Title() {
    val transition = rememberInfiniteTransition()

    val floatY by transition.animateFloat(
        initialValue = FloatYInitial,
        targetValue = FloatYTarget,
        animationSpec = infiniteRepeatable(
            animation = tween(FloatYDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val rotation by transition.animateFloat(
        initialValue = RotationStart,
        targetValue = RotationEnd,
        animationSpec = infiniteRepeatable(
            animation = tween(RotationDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = HorizontalPadding)
    ) {
        Text(
            text = "KariAI",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.ExtraBold,
                fontSize = LogoFontSize,
                lineHeight = LogoLineHeight
            )
        )

        Spacer(modifier = Modifier.height(LogoSpacerHeight))

        Box(
            modifier = Modifier.height(BoxHeight),
            contentAlignment = Alignment.BottomCenter
        ) {
            // Анимированный робот
            Image(
                painter = painterResource(MR.images.kariai_robot),
                contentDescription = null,
                modifier = Modifier
                    .height(RobotHeight)
                    .offset(y = floatY.dp + FloatYOffsetAdjustment.dp)
                    .graphicsLayer {
                        rotationZ = rotation
                    }
            )

            // Логотип
            Image(
                painter = painterResource(MR.images.main_logo),
                contentDescription = null,
                modifier = Modifier.height(BoxHeight)
            )
        }

        Spacer(modifier = Modifier.height(BelowBoxSpacer))

        Text(
            text = t("home.hello"),
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.ExtraBold,
                fontSize = HelloFontSize,
                lineHeight = HelloLineHeight
            ),
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(SubTextSpacer))

        Text(
            text = t("home.hello_in_down"),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Medium,
                fontSize = SubTextFontSize,
                lineHeight = SubTextLineHeight
            ),
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = SubTextAlpha)
        )
    }
}