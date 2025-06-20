package app.kariai.composeapp.components.common.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.compose.painterResource

// sizes
private val SearchFieldHeight = 58.dp
private val SearchFieldCornerRadius = 12.dp
private val SearchFieldStartPadding = 10.dp
private val SearchFieldIconSize = 40.dp

// alpha
private const val SearchFieldUnfocusedBorderAlpha = 0.2f

@Composable
fun SearchField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    image: ImageResource? = null,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        leadingIcon = {
            if (image != null) {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier
                        .height(SearchFieldIconSize)
                        .padding(start = SearchFieldStartPadding)
                )
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .height(SearchFieldHeight)
            .padding(start = SearchFieldStartPadding),
        shape = RoundedCornerShape(SearchFieldCornerRadius),
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = SearchFieldUnfocusedBorderAlpha),
            focusedBorderColor = MaterialTheme.colorScheme.primary
        )
    )
}