package com.dragonfruit.litrosdeagua.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.dragonfruit.litrosdeagua.R
import com.dragonfruit.litrosdeagua.data.BehaviourList
import com.dragonfruit.litrosdeagua.ui.theme.LitrosDeAguaTheme

@Composable
fun PointerHeader(consumption: Float){
    Column(
        modifier = Modifier.height(80.dp)
    ) {
        Text(
            text = "$consumption",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            fontSize = TextUnit(value = 40f, type = TextUnitType.Sp),
        )
        Text(
            text = stringResource(R.string.MeasureInLiters),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontSize = TextUnit(value = 12f, type = TextUnitType.Sp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PointerHeaderPreview() {
    LitrosDeAguaTheme {
        PointerHeader(consumption = 9.12f)
    }
}

