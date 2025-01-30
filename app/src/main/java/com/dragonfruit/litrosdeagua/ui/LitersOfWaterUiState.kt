package com.dragonfruit.litrosdeagua.ui
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.dragonfruit.litrosdeagua.R
import com.dragonfruit.litrosdeagua.data.Behaviour
import com.dragonfruit.litrosdeagua.data.BehaviourList

data class LitersOfWaterUiState(
    val litersOfWaterScreen: LitersOfWaterScreen = LitersOfWaterScreen.BEHAVIOUR_SCREEN,
    val behaviourButtonActive: Boolean =  true,
    val wateringButtonActive: Boolean = false,
    val consumptionAmount: Float = 0F,
    val behaviourList: List<Behaviour> = BehaviourList.behaviours,
    val plantWaterLevel: Float = 0F,
    @DrawableRes val favouritePlant: Int = R.drawable.bull1,
)
