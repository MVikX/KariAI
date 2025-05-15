package app.kariai.composeapp.ui.screens.main.sections.arc
//TODO пределать значки картинок + сделать автоматизацию + локализацию
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.kariai.composeapp.resources.NutriTheme
import app.kariai.composeapp.ui.screens.main.sections.arc.components.ArcScreenContainer
import app.kariai.composeapp.ui.screens.main.sections.arc.components.BurnedItem
import app.kariai.composeapp.ui.screens.main.sections.arc.components.FoodItem
import app.kariai.composeapp.ui.screens.main.components.arc.InfinityProgressArc

// layout values
private val HorizontalScreenPadding = 24.dp
private val ArcContentPadding = 16.dp
private val ColumnSpacing = 8.dp
private val ColumnGap = 16.dp
private val BottomSpacerHeight = 24.dp
private val BetweenArcAndList = 16.dp

@Composable
fun ArcOverlayScreen(
    spentKcal: Int,
    burnedKcal: Int,
    onClose: () -> Unit,
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
                    .padding(horizontal = HorizontalScreenPadding)
                    .systemBarsPadding()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                InfinityProgressArc(
                    spentKcal = spentKcal,
                    burnedKcal = burnedKcal,
                )

                Spacer(modifier = Modifier.height(BetweenArcAndList))

                ArcScreenContainer(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(ArcContentPadding)
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Съеденные", // TODO: локализовать
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(Modifier.height(ColumnSpacing))

                            FoodItem(
                                icon = Icons.Default.Search, // TODO: заменить на кастом
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

                        Spacer(modifier = Modifier.width(ColumnGap))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Потраченные", // TODO: локализовать
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(Modifier.height(ColumnSpacing))

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

                Spacer(modifier = Modifier.height(BottomSpacerHeight))

                IconButton(onClick = onClose) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Закрыть" // TODO: локализовать
                    )
                }
            }
        }
    }
}