package org.example.kariai.ui.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import org.example.kariai.resources.NutriTheme
import org.example.kariai.ui.screens.main.arc.ArcOverlay
import org.example.kariai.ui.screens.main.carbs.CarbsOverlay
import org.example.kariai.ui.screens.main.components.arc.InfinityProgressArc
import org.example.kariai.ui.screens.main.components.assistantpanel.AssistantPanel
import org.example.kariai.ui.screens.main.components.stats.StatsGrid
import org.example.kariai.ui.screens.main.components.week.WeekCircleSummaryRow
import org.example.kariai.ui.screens.main.distance.DistanceOverlay
import org.example.kariai.ui.screens.main.fat.FatOverlay
import org.example.kariai.ui.screens.main.goals.GoalsOverlay
import org.example.kariai.ui.screens.main.protein.ProteinOverlay
import org.example.kariai.ui.screens.main.steps.StepsOverlay
import org.example.kariai.ui.screens.main.week.WeekOverlay
import org.example.kariai.ui.screens.main.widget.assistantpanel.AssistantBottomSheet

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


    NutriTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 24.dp)
                        .systemBarsPadding()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    InfinityProgressArc( //TODO требует доработки логики и автоматики
                        onClick = { offset ->
                            arcClickOffset.value = offset
                            arcOverlayVisible.value = true
                        }
                    )


                    StatsGrid(
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


                    Spacer(modifier = Modifier.height(35.dp))


                    WeekCircleSummaryRow(//TODO требует логики и исправлений
                        spentList = listOf(0.4f, 0.6f, 0.3f, 0.5f, 0.8f, 0.9f, 0.2f),
                        eatenList = listOf(0.6f, 0.4f, 0.7f, 0.5f, 0.2f, 0.1f, 0.8f),
                        onClick = { offset ->
                            weekOffset.value = offset
                            weekOverlayVisible.value = true
                        }
                    )


                    Spacer(modifier = Modifier.height(35.dp))


                    //TODO демо асистент
                    AssistantPanel(onClick = {
                        assistantOverlayVisible.value = true
                    })
                }



                //АркЭкран вызов
                ArcOverlay(
                    visible = arcOverlayVisible.value,
                    offset = arcClickOffset.value,
                    onDismiss = { arcOverlayVisible.value = false }
                )


                //Дистанция вызов
                DistanceOverlay(
                    visible = distanceOverlayVisible.value,
                    offset = distanceOffset.value,
                    onDismiss = { distanceOverlayVisible.value = false }
                )

                //шаги вызов
                StepsOverlay(
                    visible = stepsOverlayVisible.value,
                    offset = stepsOffset.value,
                    onDismiss = { stepsOverlayVisible.value = false }
                )


                //ачивки вызов
                GoalsOverlay(
                    visible = goalsOverlayVisible.value,
                    offset = goalsOffset.value,
                    onDismiss = { goalsOverlayVisible.value = false }
                )


                //карбис вызов
                CarbsOverlay(
                    visible = carbsOverlayVisible.value,
                    offset = carbsOffset.value,
                    onDismiss = { carbsOverlayVisible.value = false }
                )


                //протеин вызов
                ProteinOverlay(
                    visible = proteinOverlayVisible.value,
                    offset = proteinOffset.value,
                    onDismiss = { proteinOverlayVisible.value = false }
                )


                //фат вызов
                FatOverlay(
                    visible = fatOverlayVisible.value,
                    offset = fatOffset.value,
                    onDismiss = { fatOverlayVisible.value = false }
                )


                //недели вызов
                WeekOverlay(
                    visible = weekOverlayVisible.value,
                    offset = weekOffset.value,
                    onDismiss = { weekOverlayVisible.value = false }
                )


                //асистент вызов
                AssistantBottomSheet(
                    visible = assistantOverlayVisible.value,
                    onDismiss = { assistantOverlayVisible.value = false }
                )
            }
        }
    }
}