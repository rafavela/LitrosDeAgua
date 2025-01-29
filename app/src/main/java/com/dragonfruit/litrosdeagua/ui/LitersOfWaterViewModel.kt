package com.dragonfruit.litrosdeagua.ui

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.dragonfruit.litrosdeagua.R
import com.dragonfruit.litrosdeagua.data.Action
import com.dragonfruit.litrosdeagua.data.Behaviour
import com.dragonfruit.litrosdeagua.data.BehaviourList
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

    fun addWaterConsumption(selectedBehaviour: Behaviour, selectedAction: Action){
        val behaviourListCopy = updateSelectedBehaviour(selectedBehaviour, selectedAction)
        val newConsumptionAmount = behaviourListCopy.map { it.waterConsumed }.sum()

        _uiState.update {
            it.copy(
                behaviourList = behaviourListCopy.toList(),
                consumptionAmount = newConsumptionAmount,
            )
        }
    }

    fun waterPlant(){
        _uiState.update {
            it.copy(
                plantWaterLevel = it.consumptionAmount + it.plantWaterLevel,
                consumptionAmount = 0F,
                behaviourList = BehaviourList.behaviours,
            )
        }
    }

    private fun updateSelectedBehaviour(
        selectedBehaviour: Behaviour,
        selectedAction: Action
    ): List<Behaviour>{
        val behaviourListCopy =
            _uiState
                .value
                .behaviourList
                .toMutableList()
        val indexBehaviour = behaviourListCopy.indexOf(selectedBehaviour)
        val actionListCopy = behaviourListCopy[indexBehaviour].actionList
        val indexAction = actionListCopy.indexOf(selectedAction)
        val newActionList =
            actionListCopy
                .map { it.copy(isActionSelected = false) }
                .toMutableList()
        newActionList[indexAction] = newActionList[indexAction].copy(isActionSelected = true)

        behaviourListCopy[indexBehaviour] =
            behaviourListCopy[indexBehaviour].copy(
                waterConsumed = selectedAction.waterConsumed,
                actionList = newActionList
            )

        return behaviourListCopy
    }

    fun choosePlant(chosenPlant: Int){
        _uiState.update {
            it.copy(favouritePlant = chosenPlant)
        }
    }

    fun resetState(){
        _uiState.update {
            it.copy(
                consumptionAmount = 0F,
                plantWaterLevel = 0F,
                behaviourList = BehaviourList.behaviours,
                favouritePlant= R.drawable.bull1,
            )
        }
    }
}