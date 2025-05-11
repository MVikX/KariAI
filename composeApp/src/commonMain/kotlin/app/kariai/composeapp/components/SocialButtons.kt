package app.kariai.composeapp.components

//TODO переделать кнопки на нормальные + одобренные + логику

import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.icerock.moko.resources.compose.painterResource
import app.kariai.composeapp.localization.t
import app.kariai.composeapp.utils.PlatformUtils
import app.kariai.shared.MR
import dev.icerock.moko.resources.ImageResource
import kotlinx.coroutines.delay


@Composable
fun GoogleSignButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    GoogleBorderButton(
        image = MR.images.wwwGogle,
        text = text,
        onClick = onClick,
        modifier = modifier,
    )

    /*
    SocialSignButton(
        image = MR.images.google_icons,
        text = text,
        onClick = onClick,
        modifier = modifier
    )

     */
}
@Composable
fun FacebookSignButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FacebookBorderButton(
        image = MR.images.wwwFaceBook,
        text = text,
        onClick = onClick,
        modifier = modifier
    )
}


@Composable
fun AppleSignButton( //TODO заглушка для кнопки эпл
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(50.dp)
            .border(1.dp, Color(0xFF8E918F), RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        ),
        contentPadding = PaddingValues(horizontal = 16.dp),
        enabled = false
    ) {
        Text(
            text = text,
            color = Color(0xFFE3E3E3),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 20.sp
        )
    }
}


@Composable
private fun SocialSignButton( //TODO сделать автоматику цвета
    image: ImageResource,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth()
            .border(
                width = 2.dp,
                color = Color(0xFF1AFFFF),
                shape = RoundedCornerShape(50)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .border(
                        width = 2.dp,
                        color = Color(0xFFFF9B00),
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = text,
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}


@Composable
fun GoogleBorderButton( //TODO добавить автоматизацию цвета
    text: String,
    image: ImageResource,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val orangeProgress = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        while (true) {
            orangeProgress.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 2000, easing = LinearEasing)
            )
            orangeProgress.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = 2000, easing = LinearEasing)
            )
            delay(100)
        }
    }

    Box(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth()
            .padding(2.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val strokeWidth = 3.dp.toPx()
            val width = size.width

            val orangeEnd = 0.5f + (orangeProgress.value * 0.5f)
            val blendWidth = 0.2f

            drawRoundRect(
                brush = Brush.horizontalGradient(
                    colorStops = arrayOf(
                        0.0f to Color(0xFFFF9B00),
                        (orangeEnd - blendWidth).coerceIn(0f, 1f) to Color(0xFFFF9B00),
                        orangeEnd.coerceIn(0f, 1f) to Color(0xFF1AFFFF),
                        1.0f to Color(0xFF1AFFFF)
                    )
                ),
                cornerRadius = CornerRadius(28.dp.toPx()),
                style = Stroke(width = strokeWidth)
            )
        }

        Row(
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(28.dp))
                .background(Color(0xFF121212))
                .clickable { onClick() }
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = text,
                color = Color.White,
                fontSize = 14.sp,
            )
        }
    }
}


@Composable
fun FacebookBorderButton( //TODO добавить автоматизацию цвета
    text: String,
    image: ImageResource,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val blueProgress = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        while (true) {
            blueProgress.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 2000, easing = LinearEasing)
            )
            blueProgress.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = 2000, easing = LinearEasing)
            )
            delay(100)
        }
    }

    Box(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth()
            .padding(2.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val strokeWidth = 3.dp.toPx()
            val width = size.width

            val blueStart = 0.5f - (blueProgress.value * 0.5f)
            val blendWidth = 0.2f

            drawRoundRect(
                brush = Brush.horizontalGradient(
                    colorStops = arrayOf(
                        0.0f to Color(0xFF1AFFFF), // синий левый край
                        blueStart.coerceIn(0f, 1f) to Color(0xFF1AFFFF), // расширение синего
                        (blueStart + blendWidth).coerceIn(0f, 1f) to Color(0xFFFF9B00), // начало оранжевого
                        1.0f to Color(0xFFFF9B00) // финал оранжевого
                    )
                ),
                cornerRadius = CornerRadius(28.dp.toPx()),
                style = Stroke(width = strokeWidth)
            )
        }

        Row(
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(28.dp))
                .background(Color(0xFF121212))
                .clickable { onClick() }
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = text,
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}






@Composable
fun SocialSignInButtonsRow(
    onGoogleClick: () -> Unit,
    onFacebookClick: () -> Unit,
    onAppleClick: () -> Unit,
) {
    val isIOS = PlatformUtils.isIOS()

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        GoogleSignButton(
            text = t("auth.login_with_google"),
            onClick = onGoogleClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )

        FacebookSignButton(
            text = t("auth.login_with_facebook"),
            onClick = onFacebookClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )

        if (isIOS) {
            AppleSignButton(
                text = t("auth.login_with_apple"),
                onClick = onAppleClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            )
        }
    }
}


@Composable
fun SocialSignUpButtonsRow(
    onGoogleClick: () -> Unit,
    onFacebookClick: () -> Unit,
    onAppleClick: () -> Unit,
) {
    val isIOS = PlatformUtils.isIOS()

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        GoogleSignButton(
            text = t("auth.signup_with_google"),
            onClick = onGoogleClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )

        FacebookSignButton(
            text = t("auth.signup_with_facebook"),
            onClick = onFacebookClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )

        if (isIOS) {
            AppleSignButton(
                text = t("auth.login_with_apple"),
                onClick = onAppleClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            )
        }
    }
}