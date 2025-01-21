package com.dragonfruit.litrosdeagua.ui
import androidx.compose.ui.graphics.Color

data class LitersOfWaterUiState(
    val litersOfWaterScreen: LitersOfWaterScreen = LitersOfWaterScreen.BEHAVIOUR_SCREEN,
    val behaviourButtonColor: Color = Color.Green,
    val wateringButtonColor: Color = Color.White,
)
