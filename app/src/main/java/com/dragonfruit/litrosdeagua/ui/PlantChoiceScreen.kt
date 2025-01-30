package com.dragonfruit.litrosdeagua.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dragonfruit.litrosdeagua.R
import com.dragonfruit.litrosdeagua.data.DataSource
import com.dragonfruit.litrosdeagua.ui.theme.LitrosDeAguaTheme

@Composable
fun PlantChoiceLayout(
    viewModel: LitersOfWaterViewModel = LitersOfWaterViewModel(),
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    val plantChoices = DataSource.plantChoices
    var chosenPlant by remember{ mutableIntStateOf(value=R.drawable.bull1) }
    var indexPlant by remember{ mutableIntStateOf(value = 0) }
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxSize().padding(8.dp)
        ) {
            Text(
                text = stringResource(R.string.ChoosePlant),
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                style = MaterialTheme.typography.displaySmall,
            )
            Button(
                onClick = {
                    indexPlant = if (indexPlant < plantChoices.size - 1) indexPlant + 1 else 0
                    chosenPlant = plantChoices[indexPlant]
                    viewModel.choosePlant(chosenPlant)
                },
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                colors = ButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Transparent,
                    disabledContentColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                )
            ) {
                Image(
                    painter = painterResource(chosenPlant),
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.large_image_size))
                )
            }
            Button(
                onClick = onNextClick,
                modifier = Modifier.align(alignment = Alignment.End),
                colors = ButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContentColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                )
            ) {
                Text(text = stringResource(R.string.Continue))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PlantChoiceLayoutPreview(){
    LitrosDeAguaTheme {
        PlantChoiceLayout(
            viewModel = LitersOfWaterViewModel(),
            onNextClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlantChoiceLayoutDarkThemePreview(){
    LitrosDeAguaTheme(darkTheme = true) {
        PlantChoiceLayout(
            viewModel = LitersOfWaterViewModel(),
            onNextClick = {}
        )
    }
}


