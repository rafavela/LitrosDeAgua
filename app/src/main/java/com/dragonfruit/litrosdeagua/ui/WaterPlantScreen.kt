package com.dragonfruit.litrosdeagua.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dragonfruit.litrosdeagua.R
import com.dragonfruit.litrosdeagua.data.DataSource
import com.dragonfruit.litrosdeagua.ui.theme.LitrosDeAguaTheme

enum class WaterLevel{
    LEVEL_1,
    LEVEL_2,
    LEVEL_3
}

@Composable
fun WaterPlantLayout(
    litersOfWaterUiState: LitersOfWaterUiState,
    waterPlant:  () -> Unit
){
    val favouritePlantEvolution = getFavouritePlantEvolution(litersOfWaterUiState.favouritePlant)
    val waterLevel = getWaterLevel(litersOfWaterUiState)
    val plantState = getPlantState(waterLevel, favouritePlantEvolution)
    val goalConsumption = getGoalConsumption(waterLevel)

    Card(
        modifier =
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.85f),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
    )  {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize(),
        )  {
            Text(
                text = stringResource(
                    R.string.CurrenPlantLevel,
                    litersOfWaterUiState.plantWaterLevel
                ),
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            )
            Text(
                text = goalConsumption,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )

            Image(
                painter = painterResource(plantState),
                contentDescription = null,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.large_image_size))
                    .padding(dimensionResource(R.dimen.padding_small))
                    .fillMaxWidth()
                    .align(alignment = Alignment.CenterHorizontally),
            )
            Button(
                onClick = waterPlant,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            ) {
                Text(text = stringResource(R.string.WaterPlant))
            }
        }
    }
}

fun getFavouritePlantEvolution(@DrawableRes favouritePlant: Int): List<Int> =
    DataSource.plantEvoulutionMap[favouritePlant] ?: throw IllegalStateException()

fun getWaterLevel(litersOfWaterUiState: LitersOfWaterUiState): WaterLevel =
    when{
        litersOfWaterUiState.plantWaterLevel < 30F -> WaterLevel.LEVEL_1
        litersOfWaterUiState.plantWaterLevel >= 30F
                && litersOfWaterUiState.plantWaterLevel < 50F  -> WaterLevel.LEVEL_2
        else -> WaterLevel.LEVEL_3
    }

fun getPlantState(waterLevel: WaterLevel, plantEvolution: List<Int>): Int =
    when(waterLevel){
        WaterLevel.LEVEL_1 -> plantEvolution[0]
        WaterLevel.LEVEL_2 -> plantEvolution[1]
        WaterLevel.LEVEL_3 -> plantEvolution[2]
    }

@Composable
fun getGoalConsumption(waterLevel: WaterLevel): String =
    when(waterLevel){
        WaterLevel.LEVEL_1 -> stringResource(R.string.CurrentPlantGoal, 30.0F)
        WaterLevel.LEVEL_2 -> stringResource(R.string.CurrentPlantGoal, 50.0F)
        WaterLevel.LEVEL_3 -> stringResource(R.string.BlossomingPlant)
    }

@Preview(showBackground = true)
@Composable
fun WaterPlantLayoutPreview() {
    LitrosDeAguaTheme {
        WaterPlantLayout(
            LitersOfWaterUiState(),
            {}
        )
    }
}