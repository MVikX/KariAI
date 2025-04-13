package org.example.nutriai.ui.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.nutriai.resources.NutriTheme
import org.example.nutriai.ui.screens.main.components.arc.InfinityProgressArc
import org.example.nutriai.ui.screens.main.components.assistantpanel.AssistantPanel
import org.example.nutriai.ui.screens.main.components.stats.StatsGrid
import org.example.nutriai.ui.screens.main.components.week.WeekCircleSummaryRow

@Composable
fun MainScreen() {
    NutriTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
                    .systemBarsPadding()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                InfinityProgressArc( //TODO требует логики цифры и автоматики
                    spentKcal = 3000,
                    burnedKcal = 3000,
                    maxSpentKcal = 3000,
                    maxBurnedKcal = 3000,
                    onClick = { println("клик по графику!") }
                )



                // 2. блок метрик
                StatsGrid()

                Spacer(modifier = Modifier.height(35.dp))

                // 3. мини-круги недели с заголовком
                WeekCircleSummaryRow(
                    spentList = listOf(0.4f, 0.6f, 0.8f, 0.5f, 0.3f, 0.9f, 0.2f),
                    eatenList = listOf(0.6f, 0.4f, 0.7f, 0.8f, 0.2f, 0.5f, 0.3f)
                )

                Spacer(modifier = Modifier.height(35.dp))

                AssistantPanel(
                    onClick = { /* TODO: выдвижной ассистент */ }
                )
            }
        }
    }
}