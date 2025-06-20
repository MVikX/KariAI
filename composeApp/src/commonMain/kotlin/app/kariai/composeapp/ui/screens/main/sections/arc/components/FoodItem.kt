package app.kariai.composeapp.ui.screens.main.sections.arc.components
//TODO add support for custom drawings + localization
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.compose.painterResource

// layout values
private val ItemVerticalPadding = 8.dp
private val IconSize = 28.dp
private val IconTextSpacing = 12.dp
private const val TextColumnWeight = 1f

@Composable
fun FoodItem(
    icon: ImageResource,
    name: String,
    kcal: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = ItemVerticalPadding)
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = name,
            modifier = Modifier.size(IconSize),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.width(IconTextSpacing))

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(TextColumnWeight)
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "$kcal kcal",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}