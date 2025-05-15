package app.kariai.composeapp.ui.screens.main

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import app.kariai.composeapp.resources.NutriTheme
import app.kariai.composeapp.ui.screens.downmenu.MenuScreen
import app.kariai.composeapp.ui.screens.downmenu.animations.BottomMenuSheet
import app.kariai.composeapp.ui.screens.main.sections.arc.ArcOverlay
import app.kariai.composeapp.ui.screens.main.sections.assistantpanel.AssistantOverlay
import app.kariai.composeapp.ui.screens.main.sections.carbs.CarbsOverlay
import app.kariai.composeapp.ui.screens.main.components.arc.InfinityProgressArc
import app.kariai.composeapp.ui.screens.main.components.assistantpanel.AssistantPanel
import app.kariai.composeapp.ui.screens.main.components.downbar.CustomBottomBar
import app.kariai.composeapp.ui.screens.main.components.stats.StatsGrid
import app.kariai.composeapp.ui.screens.main.components.week.WeekCircleSummaryRow
import app.kariai.composeapp.ui.screens.main.sections.distance.DistanceOverlay
import app.kariai.composeapp.ui.screens.main.sections.fat.FatOverlay
import app.kariai.composeapp.ui.screens.main.sections.goals.GoalsOverlay
import app.kariai.composeapp.ui.screens.main.sections.protein.ProteinOverlay
import app.kariai.composeapp.ui.screens.main.sections.steps.ActivityOverlay
import app.kariai.composeapp.ui.screens.main.sections.week.WeekOverlay
import app.kariai.storage.nutrition.NutritionStats

// UI layout values
private val HorizontalScreenPadding = 24.dp
private val SectionSpacing = 20.dp
private val BottomMenuOffsetShown = 500.dp
private val BottomMenuOffsetHidden = 0.dp

@Composable
fun MainScreen() {
    val arcOverlayVisible = remember { mutableStateOf(false) }
    val arcClickOffset = remember { mutableStateOf(Offset.Zero) }

    val distanceOffset = remember { mutableStateOf(Offset.Zero) }
    val distanceOverlayVisible = remember { mutableStateOf(false) }

    val stepsOffset = remember { mutableStateOf(Offset.Zero) }
    val stepsOverlayVisible = remember { mutableStateOf(false) }

    val goalsOffset = remember { mutableStateOf(Offset.Zero) }
    val goalsOverlayVisible = remember { mutableStateOf(false) }

    val carbsOffset = remember { mutableStateOf(Offset.Zero) }
    val carbsOverlayVisible = remember { mutableStateOf(false) }

    val proteinOffset = remember { mutableStateOf(Offset.Zero) }
    val proteinOverlayVisible = remember { mutableStateOf(false) }

    val fatOffset = remember { mutableStateOf(Offset.Zero) }
    val fatOverlayVisible = remember { mutableStateOf(false) }

    val weekOffset = remember { mutableStateOf(Offset.Zero) }
    val weekOverlayVisible = remember { mutableStateOf(false) }

    val assistantOverlayVisible = remember { mutableStateOf(false) }

    val nutritionStats = remember { mutableStateOf(NutritionStats()) }
    val isMenuVisible = remember { mutableStateOf(false) }

    val selectedTab = remember { mutableStateOf("home") }



    NutriTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = HorizontalScreenPadding)
                        .systemBarsPadding()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Top, // Прокручиваемый контент сверху
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    InfinityProgressArc( //TODO требует доработки логики и автоматики
                        spentKcal = nutritionStats.value.caloriesSpent,
                        burnedKcal = nutritionStats.value.caloriesBurned + 3000,
                        onClick = { offset ->
                            arcClickOffset.value = offset
                            arcOverlayVisible.value = true
                        }
                    )


                    StatsGrid(
                        stats = nutritionStats.value,

                        onDistanceClick = { offset ->
                            distanceOffset.value = offset
                            distanceOverlayVisible.value = true
                        },
                        onStepsClick = { offset ->
                            stepsOffset.value = offset
                            stepsOverlayVisible.value = true
                        },
                        onGoalsClick = { offset ->
                            goalsOffset.value = offset
                            goalsOverlayVisible.value = true
                        },
                        onCarbsClick = { offset ->
                            carbsOffset.value = offset
                            carbsOverlayVisible.value = true
                        },
                        onProteinClick = { offset ->
                            proteinOffset.value = offset
                            proteinOverlayVisible.value = true
                        },
                        onFatClick = { offset ->
                            fatOffset.value = offset
                            fatOverlayVisible.value = true
                        }
                    )


                    Spacer(modifier = Modifier.height(SectionSpacing))


                    WeekCircleSummaryRow(//TODO требует логики и исправлений
                        spentList = listOf(0.4f, 0.6f, 0.3f, 0.5f, 0.8f, 0.9f, 0.2f),
                        eatenList = listOf(0.6f, 0.4f, 0.7f, 0.5f, 0.2f, 0.1f, 0.8f),
                        onClick = { offset ->
                            weekOffset.value = offset
                            weekOverlayVisible.value = true
                        }
                    )


                    Spacer(modifier = Modifier.height(SectionSpacing))


                    //TODO демо асистент
                    AssistantPanel(onClick = {
                        assistantOverlayVisible.value = true
                    })
                }

                // Нижний бар, растягиваемый по ширине
                val transition = updateTransition(targetState = isMenuVisible.value, label = "menu_bar_transition")
                val barOffset by transition.animateDp(label = "barOffset") {
                    if (it) BottomMenuOffsetShown else BottomMenuOffsetHidden // выезжает вверх, чтобы освободить место меню
                }


                if (isMenuVisible.value) {
                    BottomMenuSheet(
                        visible = isMenuVisible.value,
                        onDismissRequest = {
                            isMenuVisible.value = false
                            selectedTab.value = "home"
                        }
                    ) {
                        MenuScreen()
                    }
                }


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .offset(y = -barOffset)
                ) {
                    CustomBottomBar(
                        onHomeClick = { selectedTab.value = "home" },
                        onMenuClick = {
                            selectedTab.value = "menu"
                            isMenuVisible.value = true
                        },
                        onAiFoodClick = { selectedTab.value = "ai" },
                        isEnabled = !isMenuVisible.value,
                        selectedTab = selectedTab.value //
                    )
                }



                // Оверлеи
                ArcOverlay(
                    visible = arcOverlayVisible.value,
                    offset = arcClickOffset.value,
                    onDismiss = { arcOverlayVisible.value = false },
                    spentKcal = nutritionStats.value.caloriesSpent,
                    burnedKcal = nutritionStats.value.caloriesBurned,
                )

                DistanceOverlay(
                    visible = distanceOverlayVisible.value,
                    offset = distanceOffset.value,
                    onDismiss = { distanceOverlayVisible.value = false }
                )

                ActivityOverlay(
                    visible = stepsOverlayVisible.value,
                    offset = stepsOffset.value,
                    onDismiss = { stepsOverlayVisible.value = false }
                )


                GoalsOverlay(
                    visible = goalsOverlayVisible.value,
                    offset = goalsOffset.value,
                    onDismiss = { goalsOverlayVisible.value = false }
                )


                CarbsOverlay(
                    visible = carbsOverlayVisible.value,
                    offset = carbsOffset.value,
                    onDismiss = { carbsOverlayVisible.value = false }
                )


                ProteinOverlay(
                    visible = proteinOverlayVisible.value,
                    offset = proteinOffset.value,
                    onDismiss = { proteinOverlayVisible.value = false }
                )


                FatOverlay(
                    visible = fatOverlayVisible.value,
                    offset = fatOffset.value,
                    onDismiss = { fatOverlayVisible.value = false }
                )


                WeekOverlay(
                    visible = weekOverlayVisible.value,
                    offset = weekOffset.value,
                    onDismiss = { weekOverlayVisible.value = false }
                )


                AssistantOverlay(
                    visible = assistantOverlayVisible.value,
                    onDismiss = { assistantOverlayVisible.value = false },
                    nutritionStats = nutritionStats,
                )
            }
        }
    }
}