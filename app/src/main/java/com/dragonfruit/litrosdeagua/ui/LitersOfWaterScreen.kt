package com.dragonfruit.litrosdeagua.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dragonfruit.litrosdeagua.data.BehaviourList
import com.dragonfruit.litrosdeagua.ui.theme.LitrosDeAguaTheme
import androidx.lifecycle.viewmodel.compose.viewModel

enum class LitersOfWaterScreen(){
    BEHAVIOUR_SCREEN,
    WATERING_SCREEN,
}


@Composable
fun LitersOfWaterLayout(){
    val viewModel: LitersOfWaterViewModel = viewModel()
    val litersOfWaterUiStateUiState = viewModel.uiState.collectAsState().value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        Column(
            modifier =Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            PointerHeader(consumption = litersOfWaterUiStateUiState.consumptionAmount)
            NavigationLayout(
                litersOfWaterUiStateUiState,
                behaviourClick = {viewModel.showBehavioursScreen()},
                wateringClick = {viewModel.showWateringScreen()}
            )
            Spacer(
                modifier = Modifier.height(12.dp)
            )
            ShowScreen(viewModel, litersOfWaterUiStateUiState)
        }
    }
}

@Composable
fun ShowScreen(viewModel: LitersOfWaterViewModel, litersOfWaterUiStateUiState: LitersOfWaterUiState){
    when(litersOfWaterUiStateUiState.litersOfWaterScreen){
        LitersOfWaterScreen.BEHAVIOUR_SCREEN -> BehaviourLayout(
            viewModel = viewModel,
            litersOfWaterUiStateUiState = litersOfWaterUiStateUiState
        )
        LitersOfWaterScreen.WATERING_SCREEN -> WaterPlantLayout(litersOfWaterUiStateUiState) {
            viewModel.waterPlant()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LitersOfWaterLayoutPreview() {
    LitrosDeAguaTheme {
        LitersOfWaterLayout()
    }
}