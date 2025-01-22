package com.dragonfruit.litrosdeagua.ui
import androidx.compose.ui.graphics.Color
import com.dragonfruit.litrosdeagua.data.Behaviour
import com.dragonfruit.litrosdeagua.data.BehaviourList

data class LitersOfWaterUiState(
    val litersOfWaterScreen: LitersOfWaterScreen = LitersOfWaterScreen.BEHAVIOUR_SCREEN,
    val behaviourButtonColor: Color = Color.Green,
    val wateringButtonColor: Color = Color.White,
    val consumptionAmount: Float = 0F,
    val behaviourList: List<Behaviour> = BehaviourList.behaviours,
)
