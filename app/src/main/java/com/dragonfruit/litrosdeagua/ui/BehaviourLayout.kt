package com.dragonfruit.litrosdeagua.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dragonfruit.litrosdeagua.ui.theme.LitrosDeAguaTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.dragonfruit.litrosdeagua.R
import com.dragonfruit.litrosdeagua.data.Action
import com.dragonfruit.litrosdeagua.data.Behaviour
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun BehaviourLayout(
    viewModel: LitersOfWaterViewModel,
    litersOfWaterUiStateUiState: LitersOfWaterUiState
){
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items (litersOfWaterUiStateUiState.behaviourList) {
            BehaviourComponent(viewModel = viewModel, behaviour = it)
        }
    }
}

@Composable
fun BehaviourComponent(
    viewModel: LitersOfWaterViewModel,
    behaviour: Behaviour
){
    Column {
        Text(
            text = stringResource(behaviour.title) ,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
        for(action in behaviour.actionList){
            ActionComponent(
                calculateAmount = {
                    viewModel.addWaterConsumption(behaviour, action)
                                  },
                action,
            )
        }
    }
}

@Composable
fun ActionComponent(
    calculateAmount: () -> Unit,
    action: Action
){
    Button(
        onClick = calculateAmount,
        modifier = Modifier.padding(8.dp),
        colors = ButtonColors(
            containerColor = if(action.isActionSelected) Color.Green else Color.Blue,
            contentColor = Color.White,
            disabledContentColor =  if(action.isActionSelected) Color.Blue else Color.Green,
            disabledContainerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier.padding(12.dp)
        ) {
            Image(
                painter = painterResource(action.icon),
                contentDescription = null,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.image_size))
                    .padding(dimensionResource(R.dimen.padding_small)),
            )
            Text(
                text = stringResource(action.behaviour),
                modifier = Modifier.fillMaxWidth().align(Alignment.CenterVertically),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BehaviourComponentPreview() {
    LitrosDeAguaTheme {
        BehaviourLayout(
            viewModel = viewModel(),
            LitersOfWaterUiState()
        )
    }
}


