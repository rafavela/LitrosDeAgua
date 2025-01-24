package com.dragonfruit.litrosdeagua.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dragonfruit.litrosdeagua.R
import com.dragonfruit.litrosdeagua.ui.theme.LitrosDeAguaTheme

@Composable
fun NavigationLayout(
    litersOfWaterUiStateUiState: LitersOfWaterUiState,
    behaviourClick: () -> Unit,
    wateringClick:  () -> Unit,
){
    Card{
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = behaviourClick,
                colors = ButtonColors(
                    containerColor = litersOfWaterUiStateUiState.behaviourButtonColor,
                    contentColor = Color.White,
                    disabledContentColor = Color.White,
                    disabledContainerColor = Color.White
                )
            ) {
                Image(
                    painter = painterResource(R.drawable.fountain_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small)),
                )
            }
            Button(
                onClick = wateringClick,
                colors = ButtonColors(
                    containerColor = litersOfWaterUiStateUiState.wateringButtonColor,
                    contentColor = Color.White,
                    disabledContentColor = Color.White,
                    disabledContainerColor = Color.White
                )
            ) {
                Image(
                    painter = painterResource(R.drawable.watering_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small)),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationLayoutPreview() {
    LitrosDeAguaTheme {
        NavigationLayout(
            litersOfWaterUiStateUiState = LitersOfWaterUiState(),
            behaviourClick = {},
            wateringClick = {},
        )
    }
}

