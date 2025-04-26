package org.example.kariai.ui.screens.main.arc
//TODO пределать значки картинок + сделать автоматизацию + локализацию
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.kariai.resources.NutriTheme
import org.example.kariai.ui.screens.main.arc.components.ArcScreenContainer
import org.example.kariai.ui.screens.main.arc.components.BurnedItem
import org.example.kariai.ui.screens.main.arc.components.FoodItem
import org.example.kariai.ui.screens.main.components.arc.InfinityProgressArc

@Composable
fun ArcOverlayScreen(
    onClose: () -> Unit
) {
    NutriTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
                    .systemBarsPadding()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                InfinityProgressArc()

                Spacer(modifier = Modifier.height(16.dp))

                ArcScreenContainer(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Съеденные",
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(Modifier.height(8.dp))

                            // TODO: заменить стандартные иконки на свои svg (через painterResource)
                            FoodItem(
                                icon = Icons.Default.Search,
                                name = "Гречка",
                                kcal = 250
                            )
                            FoodItem(
                                icon = Icons.Default.Search,
                                name = "Курица",
                                kcal = 350
                            )
                            FoodItem(
                                icon = Icons.Default.Search,
                                name = "Молоко",
                                kcal = 150
                            )
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Потраченные",
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(Modifier.height(8.dp))

                            BurnedItem(
                                icon = Icons.Default.Search,
                                name = "Базовый обмен",
                                kcal = 1800
                            )
                            BurnedItem(
                                icon = Icons.Default.Search,
                                name = "Тренировки",
                                kcal = 1200
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                IconButton(onClick = onClose) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Закрыть"
                    )
                }
            }
        }
    }
}