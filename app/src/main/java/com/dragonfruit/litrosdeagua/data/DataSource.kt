package com.dragonfruit.litrosdeagua.data

import com.dragonfruit.litrosdeagua.R

object DataSource {
    val plantChoices = listOf(
        R.drawable.bull1,
        R.drawable.butterfly,
        R.drawable.rose1,
        R.drawable.seed_sprouting_icon,
    )

    val plantEvoulutionMap = mapOf(
        R.drawable.bull1 to listOf(R.drawable.bull1, R.drawable.bull2, R.drawable.bull3),
        R.drawable.butterfly to listOf(
            R.drawable.butterfly,
            R.drawable.butterfly2,
            R.drawable.butterfly3
        ),
        R.drawable.rose1 to listOf(R.drawable.rose1, R.drawable.rose2, R.drawable.rose3),
        R.drawable.seed_sprouting_icon to listOf(
            R.drawable.seed_sprouting_icon,
            R.drawable.seedling_icon,
            R.drawable.garden_grass_icon
        )
    )


}