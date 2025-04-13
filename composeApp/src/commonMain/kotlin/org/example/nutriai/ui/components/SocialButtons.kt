package org.example.nutriai.ui.components

//TODO переделать кнопки на нормальные + одобренные + логику

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.icerock.moko.resources.compose.painterResource
import localization.t
import org.example.nutriai.shared.MR
import org.example.nutriai.utils.PlatformUtils

@Composable
fun GoogleSignButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    SocialSignButton(
        image = MR.images.google_icons,
        text = text,
        onClick = onClick,
        modifier = modifier
    )
}
@Composable
fun TelegramSignButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    SocialSignButton(
        image = MR.images.telegram_icons,
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
private fun SocialSignButton(
    image: dev.icerock.moko.resources.ImageResource,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        contentAlignment = Alignment.CenterStart
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 120.dp),
            contentAlignment = Alignment.CenterStart
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
}




@Composable
fun SocialSignInButtonsRow(
    onGoogleClick: () -> Unit,
    onTelegramClick: () -> Unit,
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

        TelegramSignButton(
            text = t("auth.login_with_telegram"),
            onClick = onTelegramClick,
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
    onTelegramClick: () -> Unit,
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

        TelegramSignButton(
            text = t("auth.signup_with_telegram"),
            onClick = onTelegramClick,
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