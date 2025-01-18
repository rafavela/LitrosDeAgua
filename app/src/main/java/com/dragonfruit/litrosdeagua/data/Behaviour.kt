package com.dragonfruit.litrosdeagua.data

import androidx.annotation.StringRes

data class Behaviour(
    @StringRes val title: Int,
    val actionList: List<Action>,
)
