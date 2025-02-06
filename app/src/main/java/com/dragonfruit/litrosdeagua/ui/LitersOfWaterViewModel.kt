package com.dragonfruit.litrosdeagua.ui

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
                wateringButtonActive = true,
                wasteButtonActive = false,
                behaviourButtonActive = false,
            )
        }
    }

    fun showWasteScreen(){
        _uiState.update {
            it.copy(
                litersOfWaterScreen = LitersOfWaterScreen.WASTE_SCREEN,
                wateringButtonActive = false,
                wasteButtonActive = true,
                behaviourButtonActive = false,
            )
        }
    }

    fun showBehavioursScreen(){
        _uiState.update {
            it.copy(
                litersOfWaterScreen = LitersOfWaterScreen.BEHAVIOUR_SCREEN,
                wateringButtonActive = false,
                wasteButtonActive = false,
                behaviourButtonActive = true,
            )
        }
    }

    fun addWaterConsumption(
        selectedBehaviour: Behaviour,
        selectedAction: Action,
        litersOfWaterScreen: LitersOfWaterScreen,
    ){
        val behaviourCopyList = when(litersOfWaterScreen) {
            LitersOfWaterScreen.BEHAVIOUR_SCREEN -> _uiState.value.waterBehaviourList
            LitersOfWaterScreen.WASTE_SCREEN -> _uiState.value.wasteBehaviourList
            else -> throw IllegalStateException("Illegal screen state")
        }
        val newBehaviourList = updateSelectedBehaviour(
            selectedBehaviour = selectedBehaviour,
            selectedAction = selectedAction,
            behaviourListCopy = behaviourCopyList.toMutableList()
        )
        val partialConsumptionAmount = when(litersOfWaterScreen) {
                LitersOfWaterScreen.BEHAVIOUR_SCREEN -> _uiState.value.wasteBehaviourList
                LitersOfWaterScreen.WASTE_SCREEN -> _uiState.value.waterBehaviourList
                else -> throw IllegalStateException("Illegal screen state")
            }
            .calculateConsumptionAmount()
        val newConsumptionAmount = newBehaviourList.calculateConsumptionAmount()

        _uiState.update {
            when(litersOfWaterScreen) {
                LitersOfWaterScreen.BEHAVIOUR_SCREEN -> it.copy(
                    waterBehaviourList = newBehaviourList,
                    consumptionAmount = partialConsumptionAmount + newConsumptionAmount,
                )
                LitersOfWaterScreen.WASTE_SCREEN -> it.copy(
                    wasteBehaviourList = newBehaviourList,
                    consumptionAmount = partialConsumptionAmount + newConsumptionAmount,
                )
                else -> throw IllegalStateException("Illegal screen state")
            }
        }
    }

    private fun updateSelectedBehaviour(
        selectedBehaviour: Behaviour,
        selectedAction: Action,
        behaviourListCopy: MutableList<Behaviour>
    ): List<Behaviour>{
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

    private fun List<Behaviour>.calculateConsumptionAmount(): Float =
        this.toMutableList()
            .map { it.waterConsumed  }
            .sum()

    fun waterPlant(){
        _uiState.update {
            it.copy(
                plantWaterLevel = it.consumptionAmount + it.plantWaterLevel,
                consumptionAmount = 0F,
                waterBehaviourList = BehaviourList.waterBehaviours,
                wasteBehaviourList = BehaviourList.wasteBehaviours,
            )
        }
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
                waterBehaviourList = BehaviourList.waterBehaviours,
                wasteBehaviourList = BehaviourList.wasteBehaviours,
                favouritePlant= R.drawable.bull1,
            )
        }
    }
}
