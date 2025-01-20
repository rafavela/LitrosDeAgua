package com.dragonfruit.litrosdeagua.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dragonfruit.litrosdeagua.data.BehaviourList
import com.dragonfruit.litrosdeagua.ui.theme.LitrosDeAguaTheme


@Composable
fun LitersOfWaterLayout(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        Column(
            modifier =Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            PointerHeader(consumption = 9.12F)
            BehaviourLayout(BehaviourList.behaviours)
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