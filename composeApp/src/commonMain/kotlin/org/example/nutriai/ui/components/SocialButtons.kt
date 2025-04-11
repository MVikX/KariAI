package org.example.nutriai.ui.components
//TODO ДОБАВИТЬ КАРТИНКИ К КНОПКА
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.sp
import org.example.nutriai.resources.google_color
import org.example.nutriai.resources.telegram_color
import org.example.nutriai.utils.PlatformUtils

@Composable
fun SocialButtonsRow (
    onGoogleClick: () -> Unit,
    onTelegramClick: () -> Unit,
    onAppleClick: () -> Unit,
) {
    val isIOS = PlatformUtils.isIOS()

    Column (
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row (
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SocialButton("Telegram", onTelegramClick)
            SocialButton("Google", onGoogleClick)
        }
        if (isIOS) {
            SocialButton("Apple", onAppleClick)
        }
    }
}


@Composable
fun SocialButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = when (label) {
        "Telegram" -> telegram_color
        "Google" -> google_color
        "Apple" -> Color.Black
        else -> Color.DarkGray
    }

    //TODO пока иконок нет — заглушка
    val icon: @Composable (() -> Unit)? = null

    Button(
        onClick = onClick,
        modifier = modifier.height(50.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = Color.White
        )
    ) {
        //TODO в будущем иконку
        icon?.invoke()

        // текст кнопки
        Text(text = label, fontSize = 14.sp)
    }
}