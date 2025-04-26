package org.example.kariai.shared.presentation.auth.register.userdetails

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.datetime.*
import org.example.kariai.shared.presentation.auth.register.userdetails.enums.Gender
import org.example.kariai.storage.preferences.UserPreferences

class UserDetailsViewModel(
    private val preferences: UserPreferences
) {

    private val _uiState = MutableStateFlow(UserDetailsUiState())
    val uiState: StateFlow<UserDetailsUiState> = _uiState

    init {
        loadUserData()
    }

    fun calculateAge(): Int? {
        val today = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
        return try {
            val state = uiState.value
            if (state.birthDay == 0 || state.birthMonth == 0 || state.birthYear == 0) return null

            val birthday = LocalDate(
                state.birthYear,
                state.birthMonth,
                state.birthDay
            )
            birthday.until(today, DateTimeUnit.YEAR)
        } catch (e: Exception) {
            null
        }
    }

    fun loadUserData() {
        _uiState.update {
            it.copy(
                userName = preferences.getUserName() ?: "",
                weight = preferences.getWeight() ?: 75.5,
                height = preferences.getHeight() ?: 175,
                birthDay = preferences.getBirthDay() ?: 1,
                birthMonth = preferences.getBirthMonth() ?: 1,
                birthYear = preferences.getBirthYear() ?: 2000,
                allergies = "",
                intolerances = "",
            )
        }
    }

    fun updateName(name: String) {
        preferences.saveUserName(name)
        _uiState.update { it.copy(userName = name) }
    }

    fun updateBirthDay(day: Int) {
        preferences.saveBirthDay(day)
        _uiState.update { it.copy(birthDay = day) }
    }

    fun updateBirthMonth(month: Int) {
        preferences.saveBirthMonth(month)
        _uiState.update { it.copy(birthMonth = month) }
    }

    fun updateBirthYear(year: Int) {
        preferences.saveBirthYear(year)
        _uiState.update { it.copy(birthYear = year) }
    }

    fun updateHeight(height: Int) {
        preferences.saveHeight(height)
        _uiState.update { it.copy(height = height) }
    }

    fun updateWeight(weight: Double) {
        preferences.saveWeight(weight)
        _uiState.update { it.copy(weight = weight) }
    }

    fun updateGender(gender: Gender) {
        _uiState.update { it.copy(gender = gender) }
    }

    fun updateAllergies(text: String) {
        _uiState.update { it.copy(allergies = text) }
    }

    fun updateIntolerances(text: String) {
        _uiState.update { it.copy(intolerances = text) }
    }

    private val _isWeightPickerVisible = MutableStateFlow(false)
    val isWeightPickerVisible: StateFlow<Boolean> = _isWeightPickerVisible

    fun showWeightPicker() {
        _isWeightPickerVisible.value = true
    }

    fun hideWeightPicker() {
        _isWeightPickerVisible.value = false
    }

    private val _isHeightPickerVisible = MutableStateFlow(false)
    val isHeightPickerVisible: StateFlow<Boolean> = _isHeightPickerVisible

    fun showHeightPicker() {
        _isHeightPickerVisible.value = true
    }

    fun hideHeightPicker() {
        _isHeightPickerVisible.value = false
    }



    private val _isNameDialogVisible = MutableStateFlow(false)
    val isNameDialogVisible: StateFlow<Boolean> = _isNameDialogVisible

    fun showNameDialog() {
        _isNameDialogVisible.value = true
    }

    fun hideNameDialog() {
        _isNameDialogVisible.value = false
    }



    private val _isBirthDateDialogVisible = MutableStateFlow(false)
    val isBirthDateDialogVisible: StateFlow<Boolean> = _isBirthDateDialogVisible

    fun showBirthDateDialog() {
        _isBirthDateDialogVisible.value = true
    }

    fun hideBirthDateDialog() {
        _isBirthDateDialogVisible.value = false
    }
}