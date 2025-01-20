package com.dragonfruit.litrosdeagua.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dragonfruit.litrosdeagua.R
import com.dragonfruit.litrosdeagua.ui.theme.LitrosDeAguaTheme

@Composable
fun WaterPlantLayout(){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.seedling_icon),
            contentDescription = null,
            modifier = Modifier
                .size(dimensionResource(R.dimen.large_image_size))
                .padding(dimensionResource(R.dimen.padding_small))
                .fillMaxWidth()
                .align(alignment = Alignment.CenterHorizontally),
        )
        Button(
            onClick = {/*TODO*/},
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        ) {
            Text("Regar plantita")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WaterPlantLayoutPreview() {
    LitrosDeAguaTheme {
        WaterPlantLayout()
    }
}