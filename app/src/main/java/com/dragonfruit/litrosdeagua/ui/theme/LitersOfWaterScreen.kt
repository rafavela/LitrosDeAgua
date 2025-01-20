package com.dragonfruit.litrosdeagua.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dragonfruit.litrosdeagua.data.BehaviourList
import com.dragonfruit.litrosdeagua.ui.BehaviourComponent
import com.dragonfruit.litrosdeagua.ui.BehaviourLayout
import com.dragonfruit.litrosdeagua.ui.PointerHeader

@Composable
fun LitersOfWaterLayout(){
    Column {
        PointerHeader(consumption = 9.12F)
        BehaviourLayout(BehaviourList.behaviours)
    }
}

@Preview(showBackground = true)
@Composable
fun LitersOfWaterLayoutPreview() {
    LitrosDeAguaTheme {
        LitersOfWaterLayout()
    }
}