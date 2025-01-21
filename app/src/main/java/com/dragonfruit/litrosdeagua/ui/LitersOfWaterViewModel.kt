package com.dragonfruit.litrosdeagua.ui

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LitersOfWaterViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(LitersOfWaterUiState())

    val uiState: StateFlow<LitersOfWaterUiState> = _uiState

    fun showWateringScreen(){
        _uiState.update {
            it.copy(
                litersOfWaterScreen = LitersOfWaterScreen.WATERING_SCREEN,
                wateringButtonColor = Color.Green,
                behaviourButtonColor = Color.White,
            )
        }
    }

    fun showBehavioursScreen(){
        _uiState.update {
            it.copy(
                litersOfWaterScreen = LitersOfWaterScreen.BEHAVIOUR_SCREEN,
                wateringButtonColor = Color.White,
                behaviourButtonColor = Color.Green,
            )
        }
    }
}