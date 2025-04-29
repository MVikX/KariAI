package app.kariai.composeapp.resources

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF006CFF),
    onPrimary = Color.White,
    background = Color(0xFFF6F6F6),
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF2979FF),
    onPrimary = Color.White,
    background = Color(0xFF0D0D0D),
    onBackground = Color.White,
    surface = Color(0xFF1C1C1E),
    onSurface = Color(0xFFE0E0E0),
)

val telegram_color = Color(0xFF0088CC) // бирюзовый
val google_color = Color(0xFFDB4437)   // красноватый

@Composable
fun NutriTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        content = content
    )
}



@Composable
fun GlassTextField(
    label: String,
    placeholder: String,
    isPassword: Boolean = false,
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean = false,
    errorMessage: String? = null,
    isSuccess: Boolean = false,
) {
    val successColor = Color(0xFF4CAF50)

    Column {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = {
                Text(
                    text = label,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
            },
            placeholder = {
                Text(
                    text = placeholder,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
                )
            },
            singleLine = true,
            isError = isError,
            visualTransformation = if (isPassword) PasswordVisualTransformation()
            else VisualTransformation.None,

            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.surface.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(16.dp)
                ),
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = when {
                    isSuccess -> successColor
                    isError -> MaterialTheme.colorScheme.error
                    else -> Color.Transparent
                },
                unfocusedBorderColor = when {
                    isSuccess -> successColor
                    isError -> MaterialTheme.colorScheme.error
                    else -> Color.Transparent
                },
                errorBorderColor = MaterialTheme.colorScheme.error,
                cursorColor = MaterialTheme.colorScheme.primary,
            )
        )

        if (isError && errorMessage != null) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(start = 8.dp, top = 4.dp)
            )
        }
    }
}



private val AppTypography = Typography(
    headlineMedium = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = Color.White
    ),
    bodySmall = TextStyle(
        fontSize = 13.sp,
        color = Color.Gray
    )
)