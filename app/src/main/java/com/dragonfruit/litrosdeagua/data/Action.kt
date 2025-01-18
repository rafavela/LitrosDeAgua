package com.dragonfruit.litrosdeagua.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Action(
    @DrawableRes val icon: Int,
    @StringRes val behaviour: Int,
)
