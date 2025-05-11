package app.kariai.composeapp.ui.screens.main.components.downbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.kariai.shared.MR
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun CustomBottomBar(
    onHomeClick: () -> Unit,
    onMenuClick: () -> Unit,
    onAiFoodClick: () -> Unit,
    isEnabled: Boolean = true,
    selectedTab: String = "home",
) {
    val sizeIconBar = 30.dp

    BottomBarContainer(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(MR.images.ai_food),
                contentDescription = null,
                modifier = Modifier
                    .height(sizeIconBar)
                    .then(if (isEnabled) Modifier.clickable { onAiFoodClick() } else Modifier)
                    .background(
                        if (selectedTab == "ai") MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                        else Color.Transparent,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(4.dp)
            )

            Image(
                painter = painterResource(MR.images.home),
                contentDescription = null,
                modifier = Modifier
                    .height(sizeIconBar)
                    .then(if (isEnabled) Modifier.clickable { onHomeClick() } else Modifier)
                    .background(
                        if (selectedTab == "home") MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                        else Color.Transparent,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(4.dp)
            )

            Image(
                painter = painterResource(MR.images.menu),
                contentDescription = null,
                modifier = Modifier
                    .height(sizeIconBar)
                    .then(if (isEnabled) Modifier.clickable { onMenuClick() } else Modifier)
                    .background(
                        if (selectedTab == "menu") MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                        else Color.Transparent,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(4.dp)
            )
        }
    }
}