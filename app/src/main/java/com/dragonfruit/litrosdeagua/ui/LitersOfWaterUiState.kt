package com.dragonfruit.litrosdeagua.ui
import androidx.annotation.DrawableRes
import com.dragonfruit.litrosdeagua.R
import com.dragonfruit.litrosdeagua.data.Behaviour
import com.dragonfruit.litrosdeagua.data.BehaviourList

data class LitersOfWaterUiState(
    val litersOfWaterScreen: LitersOfWaterScreen = LitersOfWaterScreen.BEHAVIOUR_SCREEN,
    val behaviourButtonActive: Boolean =  true,
    val wateringButtonActive: Boolean = false,
    val wasteButtonActive: Boolean = false,
    val consumptionAmount: Float = 0F,
    val waterBehaviourList: List<Behaviour> = BehaviourList.waterBehaviours,
    val wasteBehaviourList: List<Behaviour> = BehaviourList.wasteBehaviours,
    val plantWaterLevel: Float = 0F,
    @DrawableRes val favouritePlant: Int = R.drawable.bull1,
)
