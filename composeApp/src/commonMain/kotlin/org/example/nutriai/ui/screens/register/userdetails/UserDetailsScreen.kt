package org.example.nutriai.ui.screens.register.userdetails

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.nutriai.resources.NutriTheme
import org.example.nutriai.shared.presentation.auth.register.userdetails.UserDetailsViewModel
import org.example.nutriai.ui.components.common.button.GradientButton
import org.example.nutriai.ui.components.common.search.SearchField
import org.example.nutriai.ui.screens.register.userdetails.components.*

@Composable
fun UserDetailsScreen(
    viewModel: UserDetailsViewModel,
    onContinueClick: () -> Unit
) {
    val uiState = viewModel.uiState.collectAsState().value
    val isWeightPickerVisible = viewModel.isWeightPickerVisible.collectAsState().value
    val isHeightPickerVisible = viewModel.isHeightPickerVisible.collectAsState().value

    NutriTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
                    .systemBarsPadding(),
                verticalArrangement = Arrangement.Center,
            ) {

                Spacer(modifier = Modifier.height(35.dp))

                GenderSelector(
                    selectedGender = uiState.gender,
                    onGenderSelected = { viewModel.updateGender(it) }
                )

                Spacer(modifier = Modifier.height(35.dp))

                AgeSelector(
                    age = uiState.age,
                    onAgeChange = { viewModel.updateAge(it) }
                )

                Spacer(modifier = Modifier.height(35.dp))

                BodyMetricsSelector(
                    height = uiState.height,
                    weight = uiState.weight,
                    onHeightClick = { viewModel.showHeightPicker() },
                    onWeightClick = { viewModel.showWeightPicker() },
                )

                Spacer(modifier = Modifier.height(35.dp))

                SearchField(
                    label = "Allergies",
                    value = uiState.allergies,
                    onValueChange = { viewModel.updateAllergies(it) }
                )

                Spacer(modifier = Modifier.height(35.dp))

                SearchField(
                    label = "Intolerances",
                    value = uiState.intolerances,
                    onValueChange = { viewModel.updateIntolerances(it) }
                )

                Spacer(modifier = Modifier.height(35.dp))



                ContinueButton(uiState = uiState, onClick = onContinueClick)
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.loadUserData()
    }

    // список веса
    if (isWeightPickerVisible) {
        WeightPickerBottomSheet(
            initialWeight = uiState.weight,
            onConfirm = { viewModel.updateWeight(it) },
            onDismiss = { viewModel.hideWeightPicker() }
        )
    }

    // список роста
    if (isHeightPickerVisible) {
        HeightPickerBottomSheet(
            initialHeight = uiState.height,
            onConfirm = { viewModel.updateHeight(it) },
            onDismiss = { viewModel.hideHeightPicker() }
        )
    }
}