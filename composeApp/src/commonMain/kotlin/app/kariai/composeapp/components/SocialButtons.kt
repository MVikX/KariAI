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


// размеры и радиусы
private val SocialButtonHeight = 56.dp
private val AppleButtonHeight = 50.dp
private val BorderPadding = 2.dp
private val BorderStrokeWidth = 3.dp
private val RoundedCornerRadius = 28.dp
private val AppleCornerRadius = 12.dp
private val AppleBorderWidth = 1.dp
private val InnerIconSize = 20.dp
private val IconBoxSize = 32.dp
private val LargeIconSize = 40.dp
private val HorizontalContentPadding = 20.dp
private val TextPaddingStart = 12.dp
private val OuterSpacing = 16.dp
private val CircleCornerRadius = 50.dp
private val InnerBoxCornerRadius = 8.dp

// шрифт
private val ButtonTextFontSize = 14.sp
private val AppleLineHeight = 20.sp

// цвета
private val Orange = Color(0xFFFF9B00)
private val Cyan = Color(0xFF1AFFFF)
private val AppleBorderColor = Color(0xFF8E918F)
private val AppleTextColor = Color(0xFFE3E3E3)
private val DarkBackground = Color(0xFF121212)
private val WhiteColor = Color.White
private val BlackColor = Color.Black

// анимация и логика
private const val AnimationDuration = 2000
private const val DelayDuration = 100
private const val BlendWidth = 0.2f
private const val Half = 0.5f
private const val Zero = 0.0f
private const val One = 1.0f

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
            .height(AppleButtonHeight)
            .border(AppleBorderWidth, AppleBorderColor, RoundedCornerShape(AppleCornerRadius)),
        shape = RoundedCornerShape(AppleCornerRadius),
        colors = ButtonDefaults.buttonColors(
            containerColor = BlackColor,
            contentColor = WhiteColor
        ),
        contentPadding = PaddingValues(horizontal = HorizontalContentPadding),
        enabled = false
    ) {
        Text(
            text = text,
            color = AppleTextColor,
            fontSize = ButtonTextFontSize,
            fontWeight = FontWeight.Medium,
            lineHeight = AppleLineHeight
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
            .height(SocialButtonHeight)
            .fillMaxWidth()
            .border(BorderStrokeWidth, Cyan, RoundedCornerShape(CircleCornerRadius))
            .clickable { onClick() },
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = HorizontalContentPadding)
        ) {
            Box(
                modifier = Modifier
                    .size(IconBoxSize)
                    .border(BorderStrokeWidth, Orange, RoundedCornerShape(InnerBoxCornerRadius)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier.size(InnerIconSize)
                )
            }

            Spacer(modifier = Modifier.width(HorizontalContentPadding))

            Text(
                text = text,
                color = WhiteColor,
                fontSize = ButtonTextFontSize,
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
    val orangeProgress = remember { Animatable(Zero) }

    LaunchedEffect(Unit) {
        while (true) {
            orangeProgress.animateTo(One, animationSpec = tween(AnimationDuration, easing = LinearEasing))
            orangeProgress.animateTo(Zero, animationSpec = tween(AnimationDuration, easing = LinearEasing))
            delay(DelayDuration.toLong())
        }
    }

    Box(
        modifier = modifier
            .height(SocialButtonHeight)
            .fillMaxWidth()
            .padding(BorderPadding),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val strokeWidth = BorderStrokeWidth.toPx()
            val orangeEnd = Half + (orangeProgress.value * Half)

            drawRoundRect(
                brush = Brush.horizontalGradient(
                    colorStops = arrayOf(
                        Zero to Orange,
                        (orangeEnd - BlendWidth).coerceIn(Zero, One) to Orange,
                        orangeEnd.coerceIn(Zero, One) to Cyan,
                        One to Cyan
                    )
                ),
                cornerRadius = CornerRadius(RoundedCornerRadius.toPx()),
                style = Stroke(width = strokeWidth)
            )
        }

        Row(
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(RoundedCornerRadius))
                .background(DarkBackground)
                .clickable { onClick() }
                .padding(horizontal = HorizontalContentPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier.size(LargeIconSize)
            )
            Spacer(modifier = Modifier.width(TextPaddingStart))
            Text(
                text = text,
                color = WhiteColor,
                fontSize = ButtonTextFontSize,
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
    val blueProgress = remember { Animatable(Zero) }

    LaunchedEffect(Unit) {
        while (true) {
            blueProgress.animateTo(One, animationSpec = tween(AnimationDuration, easing = LinearEasing))
            blueProgress.animateTo(Zero, animationSpec = tween(AnimationDuration, easing = LinearEasing))
            delay(DelayDuration.toLong())
        }
    }

    Box(
        modifier = modifier
            .height(SocialButtonHeight)
            .fillMaxWidth()
            .padding(BorderPadding),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val strokeWidth = BorderStrokeWidth.toPx()
            val blueStart = Half - (blueProgress.value * Half)

            drawRoundRect(
                brush = Brush.horizontalGradient(
                    colorStops = arrayOf(
                        Zero to Cyan, // синий левый край
                        blueStart.coerceIn(Zero, One) to Cyan,
                        (blueStart + BlendWidth).coerceIn(Zero, One) to Orange,
                        One to Orange
                    )
                ),
                cornerRadius = CornerRadius(RoundedCornerRadius.toPx()),
                style = Stroke(width = strokeWidth)
            )
        }

        Row(
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(RoundedCornerRadius))
                .background(DarkBackground)
                .clickable { onClick() }
                .padding(horizontal = HorizontalContentPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier.size(LargeIconSize)
            )
            Spacer(modifier = Modifier.width(TextPaddingStart))
            Text(
                text = text,
                color = WhiteColor,
                fontSize = ButtonTextFontSize
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
        verticalArrangement = Arrangement.spacedBy(OuterSpacing),
        modifier = Modifier.fillMaxWidth()
    ) {
        GoogleSignButton(
            text = t("auth.login_with_google"),
            onClick = onGoogleClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(SocialButtonHeight)
        )

        FacebookSignButton(
            text = t("auth.login_with_facebook"),
            onClick = onFacebookClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(SocialButtonHeight)
        )

        if (isIOS) {
            AppleSignButton(
                text = t("auth.login_with_apple"),
                onClick = onAppleClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(SocialButtonHeight)
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
        verticalArrangement = Arrangement.spacedBy(OuterSpacing),
        modifier = Modifier.fillMaxWidth()
    ) {
        GoogleSignButton(
            text = t("auth.signup_with_google"),
            onClick = onGoogleClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(SocialButtonHeight)
        )

        FacebookSignButton(
            text = t("auth.signup_with_facebook"),
            onClick = onFacebookClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(SocialButtonHeight)
        )

        if (isIOS) {
            AppleSignButton(
                text = t("auth.login_with_apple"),
                onClick = onAppleClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(SocialButtonHeight)
            )
        }
    }
}