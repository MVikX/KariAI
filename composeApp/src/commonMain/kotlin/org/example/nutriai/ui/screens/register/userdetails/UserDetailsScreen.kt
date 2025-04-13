package org.example.nutriai.ui.screens.register.userdetails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import localization.t
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
    val isNameDialogVisible = viewModel.isNameDialogVisible.collectAsState().value
    val isBirthDateDialogVisible = viewModel.isBirthDateDialogVisible.collectAsState().value

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
            ) {
                Spacer(modifier = Modifier.height(35.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        NameInput(
                            name = uiState.userName,
                            onClick = { viewModel.showNameDialog() }
                        )
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        BirthDateSelector(
                            day = uiState.birthDay,
                            month = uiState.birthMonth,
                            year = uiState.birthYear,
                            onClick = { viewModel.showBirthDateDialog() }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(35.dp))

                GenderSelector(
                    selectedGender = uiState.gender,
                    onGenderSelected = { viewModel.updateGender(it) }
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
                    label = t("profile.allergies"),
                    value = uiState.allergies,
                    onValueChange = { viewModel.updateAllergies(it) }
                )

                Spacer(modifier = Modifier.height(35.dp))

                SearchField(
                    label = t("profile.intolerances"),
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

    if (isWeightPickerVisible) {
        WeightPickerBottomSheet(
            initialWeight = uiState.weight,
            onConfirm = { viewModel.updateWeight(it) },
            onDismiss = { viewModel.hideWeightPicker() }
        )
    }

    if (isHeightPickerVisible) {
        HeightPickerBottomSheet(
            initialHeight = uiState.height,
            onConfirm = { viewModel.updateHeight(it) },
            onDismiss = { viewModel.hideHeightPicker() }
        )
    }

    if (isNameDialogVisible) {
        NameInputDialog(
            name = uiState.userName,
            onDismiss = { viewModel.hideNameDialog() },
            onConfirm = {
                viewModel.updateName(it)
                viewModel.hideNameDialog()
            }
        )
    }


    if (isBirthDateDialogVisible) {
        val controller = CreateDatePickerController()

        controller.show(
            initialYear = uiState.birthYear,
            initialMonth = uiState.birthMonth,
            initialDay = uiState.birthDay
        ) { year, month, day ->
            viewModel.updateBirthYear(year)
            viewModel.updateBirthMonth(month)
            viewModel.updateBirthDay(day)
        }

        viewModel.hideBirthDateDialog()
    }
}