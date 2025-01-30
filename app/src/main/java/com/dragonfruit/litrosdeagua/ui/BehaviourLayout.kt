package com.dragonfruit.litrosdeagua.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun BehaviourLayout(
    viewModel: LitersOfWaterViewModel,
    litersOfWaterUiStateUiState: LitersOfWaterUiState,
    modifier: Modifier = Modifier,
){
    LazyColumn(
        modifier = Modifier.fillMaxHeight(0.85f)
    ) {
        items (litersOfWaterUiStateUiState.behaviourList) {
            BehaviourComponent(viewModel = viewModel, behaviour = it)
        }
    }
}

@Composable
private fun BehaviourComponentButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun BehaviourComponent(
    viewModel: LitersOfWaterViewModel,
    behaviour: Behaviour,
    modifier: Modifier = Modifier
){
    var expanded by remember { mutableStateOf(value = false) }
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Text(
                    text = stringResource(behaviour.title),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxSize(0.9f),
                    style = MaterialTheme.typography.titleLarge,
                )
                BehaviourComponentButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded  }
                )
            }
            ActionList(viewModel = viewModel, expanded= expanded, behaviour= behaviour )
        }
    }
    Spacer(Modifier.height(8.dp))
}

@Composable
fun ActionList(
    viewModel: LitersOfWaterViewModel,
    expanded: Boolean,
    behaviour: Behaviour
){
    val behaviourList = if(expanded) behaviour.actionList else emptyList()
    for (action in behaviourList) {
        ActionComponent(
            calculateAmount = {
                viewModel.addWaterConsumption(behaviour, action)
            },
            action,
        )
    }
}

@Composable
fun ActionComponent(
    calculateAmount: () -> Unit,
    action: Action
){
    Button(
        onClick = calculateAmount,
        modifier = Modifier.padding(8.dp).height(80.dp),
        colors = ButtonColors(
            containerColor = if(action.isActionSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.tertiary,
            contentColor =  if(action.isActionSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onTertiary,
            disabledContentColor =  Color.White,
            disabledContainerColor = Color.White,
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
                style = MaterialTheme.typography.bodyLarge,
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


