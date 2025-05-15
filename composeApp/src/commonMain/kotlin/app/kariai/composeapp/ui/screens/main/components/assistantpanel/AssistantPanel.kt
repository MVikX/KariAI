package app.kariai.composeapp.ui.screens.main.components.assistantpanel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.kariai.composeapp.localization.t
import app.kariai.shared.MR
import dev.icerock.moko.resources.compose.painterResource

private val PANEL_CORNER_RADIUS = 12.dp
private val PANEL_HORIZONTAL_PADDING = 16.dp
private val PANEL_VERTICAL_PADDING = 12.dp
private val ROBOT_IMAGE_HEIGHT = 30.dp
private val SPACER_WIDTH = 8.dp
private val FONT_SIZE = 16.sp

private const val SURFACE_ALPHA = 1f
private const val TEXT_OPACITY = 0.8f

@Composable
fun AssistantPanel(
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .background(
                color = MaterialTheme.colorScheme.surface.copy(alpha = SURFACE_ALPHA),
                shape = RoundedCornerShape(PANEL_CORNER_RADIUS)
            )
            .padding(horizontal = PANEL_HORIZONTAL_PADDING, vertical = PANEL_VERTICAL_PADDING),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(MR.images.kariai_robot),
                    contentDescription = null,
                    modifier = Modifier.height(ROBOT_IMAGE_HEIGHT)
                )

                Spacer(modifier = Modifier.width(SPACER_WIDTH))

                Text(
                    text = t("assistant_words.assistant") + "...",
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = TEXT_OPACITY),
                    fontSize = FONT_SIZE
                )
            }

            Text(
                text = t("small_all_wards.open"),
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = FONT_SIZE
            )
        }
    }
}