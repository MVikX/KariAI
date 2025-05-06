package app.kariai.composeapp.ui.screens.register.userdetails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.kariai.composeapp.localization.t
import app.kariai.composeapp.resources.NutriTheme
import app.kariai.composeapp.components.common.search.SearchField
import app.kariai.composeapp.ui.screens.register.userdetails.components.*
import app.kariai.shared.MR
import app.kariai.shared.presentation.auth.register.userdetails.UserDetailsViewModel

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

    NutriTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .systemBarsPadding()
                    .verticalScroll(rememberScrollState())
                    .padding(10.dp)
            ) {

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val textsize = 34.sp

                    Spacer(modifier = Modifier.height(30.dp))
                    // заголовок
                    Text(
                        text = t("profile.title_name_user1"),
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = textsize,
                            lineHeight = 44.sp
                        ),
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    Text(
                        text = t("profile.title_name_user2"),
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = textsize,
                            lineHeight = 44.sp
                        ),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .systemBarsPadding(),
                    verticalArrangement = Arrangement.spacedBy(24.dp),
                    horizontalAlignment = Alignment.Start,
                ) {
                    Spacer(modifier = Modifier.height(20.dp))

                    // Имя
                    NameInput(
                        name = uiState.userName,
                        onClick = { viewModel.showNameDialog() }
                    )

                    // Дата рождения
                    BirthDateSelector(
                        day = uiState.birthDay,
                        month = uiState.birthMonth,
                        year = uiState.birthYear,
                        onClick = { viewModel.showBirthDateDialog() }
                    )

                    // Пол
                    GenderSelector(
                        selectedGender = uiState.gender,
                        onGenderSelected = { viewModel.updateGender(it) }
                    )

                    // Рост
                    HeightSelector(
                        height = uiState.height,
                        onClick = { viewModel.showHeightPicker() }
                    )


                    WeightSelector(
                        weight = uiState.weight,
                        onClick = { viewModel.showWeightPicker() }
                    )

                    // Аллергии
                    SearchField(
                        label = t("profile.allergies"),
                        value = uiState.allergies,
                        onValueChange = { viewModel.updateAllergies(it) },
                        image = MR.images.alerg,
                    )

                    // Непереносимости
                    SearchField(
                        label = t("profile.intolerances"),
                        value = uiState.intolerances,
                        onValueChange = { viewModel.updateIntolerances(it) },
                        image = MR.images.alerg,
                    )

                    ContinueButton(
                        uiState = uiState,
                        onClick = onContinueClick,
                    )
                }
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