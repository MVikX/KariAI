package app.kariai.composeapp.ui.screens.downmenu.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun DownMenuBoxContainer(
    modifier: Modifier = Modifier,
    image: ImageResource? = null,
    onClick: (Offset) -> Unit = {},
    content: @Composable () -> Unit
) {
    var boxPosition by remember { mutableStateOf(Offset.Zero) }

    Box(
        modifier = modifier
            .onGloballyPositioned { layoutCoordinates ->
                val pos = layoutCoordinates.positionInRoot()
                boxPosition = Offset(pos.x, pos.y)
            }
            .pointerInput(Unit) {
                detectTapGestures { tapOffset ->
                    val globalOffset = boxPosition + tapOffset
                    onClick(globalOffset)
                }
            }
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 1f),
                shape = RoundedCornerShape(15.dp)
            )
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (image != null) {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier.height(20.dp)
                )
            }

            Spacer(modifier = Modifier.weight(0.5f))

            content()

            Spacer(modifier = Modifier.weight(0.5f))

            if (image != null) {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier.height(20.dp)
                )
            }
        }
    }
}