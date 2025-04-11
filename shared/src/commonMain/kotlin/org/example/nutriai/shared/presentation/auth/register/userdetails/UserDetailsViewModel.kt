package org.example.nutriai.shared.presentation.auth.register.userdetails

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.example.nutriai.shared.presentation.auth.register.userdetails.enums.Gender
import org.example.nutriai.storage.preferences.UserPreferences

class UserDetailsViewModel (
    private val preferences: UserPreferences
) {

    private val _uiState = MutableStateFlow(UserDetailsUiState())
    val uiState: StateFlow<UserDetailsUiState> = _uiState


    fun loadUserData() {
        _uiState.update {
            it.copy(
                weight = preferences.getWeight() ?: 75.5,
                height = preferences.getHeight() ?: 175,
                age = preferences.getAge() ?: 25
            )
        }
    }


    private val _isHeightPickerVisible = MutableStateFlow(false)
    val isHeightPickerVisible: StateFlow<Boolean> = _isHeightPickerVisible
    fun showHeightPicker() {
        _isHeightPickerVisible.value = true
    }


    fun hideHeightPicker() {
        _isHeightPickerVisible.value = false
    }



    fun updateAge(age: Int) {
        preferences.saveAge(age)
        _uiState.update { it.copy(age = age) }
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
}