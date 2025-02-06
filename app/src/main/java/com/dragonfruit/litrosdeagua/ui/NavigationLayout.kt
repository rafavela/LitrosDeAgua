package com.dragonfruit.litrosdeagua.ui

import androidx.annotation.DrawableRes
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
    litersOfWaterUiState: LitersOfWaterUiState,
    behaviourClick:  () -> Unit,
    wasteClick:  () -> Unit,
    wateringClick:  () -> Unit,
){
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MenuButton(
                onClick = behaviourClick,
                isColorActive = litersOfWaterUiState.behaviourButtonActive,
                imageId = R.drawable.fountain_icon,
            )
            MenuButton(
                onClick = wasteClick,
                isColorActive = litersOfWaterUiState.wasteButtonActive,
                imageId = R.drawable.recycle_icon,
            )
            MenuButton(
                onClick = wateringClick,
                isColorActive = litersOfWaterUiState.wateringButtonActive,
                imageId = R.drawable.watering_icon,
            )
        }
    }
}

@Composable
fun MenuButton(
    onClick: () -> Unit,
    isColorActive: Boolean,
    @DrawableRes imageId: Int,
){
    Button(
        onClick = onClick,
        colors = ButtonColors(
            containerColor =
            if(isColorActive){
                MaterialTheme.colorScheme.inversePrimary
            }else{
                MaterialTheme.colorScheme.tertiaryContainer
            },
            contentColor = Color.White,
            disabledContentColor = Color.White,
            disabledContainerColor = Color.White
        )
    ) {
        Image(
            painter = painterResource(imageId),
            contentDescription = null,
            modifier = Modifier
                .size(dimensionResource(R.dimen.image_size))
                .padding(dimensionResource(R.dimen.padding_small)),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationLayoutPreview() {
    LitrosDeAguaTheme {
        NavigationLayout(
            litersOfWaterUiState = LitersOfWaterUiState(),
            behaviourClick = {},
            wasteClick = {},
            wateringClick = {},
        )
    }
}
