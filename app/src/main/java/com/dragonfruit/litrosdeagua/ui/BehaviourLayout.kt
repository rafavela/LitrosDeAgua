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
import com.dragonfruit.litrosdeagua.data.BehaviourList
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn

@Composable
fun BehaviourLayout(behaviourList: List<Behaviour>){
    LazyColumn {
        items (behaviourList) {
            BehaviourComponent(it)
        }
    }
}

@Composable
fun BehaviourComponent(behaviour: Behaviour){
    Column {
        Text(
            text = stringResource(behaviour.title) ,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
        for(action in behaviour.actionList){
            ActionComponent(action)
        }
    }
}

@Composable
fun ActionComponent(
    action: Action
){
    Row{
        Image(
            painter = painterResource(action.icon),
            contentDescription = null,
            modifier = Modifier
                .size(dimensionResource(R.dimen.image_size))
                .padding(dimensionResource(R.dimen.padding_small)),
        )
        Text(
            text= stringResource(action.behaviour),
            modifier = Modifier.fillMaxWidth().align(Alignment.CenterVertically),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BehaviourComponentPreview() {
    LitrosDeAguaTheme {
        BehaviourLayout(BehaviourList.behaviours)
    }
}


