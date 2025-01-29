package com.dragonfruit.litrosdeagua.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dragonfruit.litrosdeagua.ui.theme.LitrosDeAguaTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class LitersOfWaterScreen(){
    BEHAVIOUR_SCREEN,
    WATERING_SCREEN,
    CHOOSE_SCREEN,
}

@Composable
fun AppLayout(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    val viewModel: LitersOfWaterViewModel = viewModel()
    val litersOfWaterUiStateUiState = viewModel.uiState.collectAsState().value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = LitersOfWaterScreen.CHOOSE_SCREEN.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = LitersOfWaterScreen.CHOOSE_SCREEN.name) {
                PlantChoiceLayout(
                    viewModel = viewModel,
                    onNextClick = {
                        navController.navigate(LitersOfWaterScreen.BEHAVIOUR_SCREEN.name)
                    }
                )
            }
            composable(route = LitersOfWaterScreen.BEHAVIOUR_SCREEN.name) {
                LitersOfWaterLayout(
                    innerPadding = innerPadding,
                    viewModel = viewModel,
                    litersOfWaterUiStateUiState = litersOfWaterUiStateUiState,
                    onBackButtonClick = {
                        viewModel.resetState()
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}

@Composable
fun LitersOfWaterLayout(
    innerPadding: PaddingValues,
    viewModel: LitersOfWaterViewModel,
    litersOfWaterUiStateUiState: LitersOfWaterUiState,
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    Column(
        modifier =Modifier
            .fillMaxSize()
            .padding(innerPadding),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        PointerHeader(
            onBackButtonClick = onBackButtonClick,
            consumption = litersOfWaterUiStateUiState.consumptionAmount
        )
        ShowScreen(viewModel, litersOfWaterUiStateUiState)
        NavigationLayout(
            litersOfWaterUiStateUiState,
            behaviourClick = {viewModel.showBehavioursScreen()},
            wateringClick = {viewModel.showWateringScreen()}
        )
    }
}

@Composable
fun ShowScreen(viewModel: LitersOfWaterViewModel, litersOfWaterUiStateUiState: LitersOfWaterUiState){
    when(litersOfWaterUiStateUiState.litersOfWaterScreen){
        LitersOfWaterScreen.BEHAVIOUR_SCREEN -> BehaviourLayout(
            viewModel = viewModel,
            litersOfWaterUiStateUiState = litersOfWaterUiStateUiState,
        )
        LitersOfWaterScreen.WATERING_SCREEN -> WaterPlantLayout(litersOfWaterUiStateUiState) {
            viewModel.waterPlant()
        }
        else -> PlantChoiceLayout(
            onNextClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppLayoutPreview() {
    LitrosDeAguaTheme {
        AppLayout()
    }
}