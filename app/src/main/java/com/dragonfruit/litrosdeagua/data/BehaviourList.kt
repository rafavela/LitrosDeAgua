package com.dragonfruit.litrosdeagua.data


import com.dragonfruit.litrosdeagua.R

object BehaviourList {
    val behaviours = listOf(
        Behaviour(
            title = R.string.ShowerTime,
            actionList = listOf(
                Action(icon = R.drawable.sad_icon, behaviour = R.string.MoreThanTenMinutes),
                Action(icon = R.drawable.laugh_icon, behaviour = R.string.TenMinutes),
            )
        ),
        Behaviour(
            title = R.string.Behaviour1,
            actionList = listOf(
                Action(icon = R.drawable.sad_icon, behaviour = R.string.Behaviour1Answer1),
                Action(icon = R.drawable.angry_icon, behaviour = R.string.Behaviour1Answer2),
                Action(icon = R.drawable.neutral_face_emoji_icon, behaviour = R.string.Behaviour1Answer3),
                Action(icon = R.drawable.smiley_icon, behaviour = R.string.Behaviour1Answer4),
                Action(icon = R.drawable.laugh_icon, behaviour = R.string.Behaviour1Answer5),
            )
        ),
        Behaviour(
            title = R.string.Behaviour2,
            actionList = listOf(
                Action(icon = R.drawable.sad_icon, behaviour = R.string.Behaviour2Answer1),
                Action(icon = R.drawable.angry_icon, behaviour = R.string.Behaviour2Answer2),
                Action(icon = R.drawable.neutral_face_emoji_icon, behaviour = R.string.Behaviour2Answer3),
                Action(icon = R.drawable.smiley_icon, behaviour = R.string.Behaviour2Answer4),
                Action(icon = R.drawable.laugh_icon, behaviour = R.string.Behaviour2Answer5),
            )
        ),
        Behaviour(
            title = R.string.BottledWater,
            actionList = listOf(
                Action(icon = R.drawable.sad_icon, behaviour = R.string.BottledWaterNo),
                Action(icon = R.drawable.laugh_icon, behaviour = R.string.BottledWaterYes),
            )
        ),
        Behaviour(
            title = R.string.Behaviour3,
            actionList = listOf(
                Action(icon = R.drawable.sad_icon, behaviour = R.string.Behaviour3Answer1),
                Action(icon = R.drawable.angry_icon, behaviour = R.string.Behaviour3Answer2),
                Action(icon = R.drawable.neutral_face_emoji_icon, behaviour = R.string.Behaviour3Answer3),
                Action(icon = R.drawable.smiley_icon, behaviour = R.string.Behaviour3Answer4),
                Action(icon = R.drawable.laugh_icon, behaviour = R.string.Behaviour3Answer5),
            )
        ),
        Behaviour(
            title = R.string.Behaviour4,
            actionList = listOf(
                Action(icon = R.drawable.sad_icon, behaviour = R.string.Behaviour4Answer1),
                Action(icon = R.drawable.angry_icon, behaviour = R.string.Behaviour4Answer2),
                Action(icon = R.drawable.neutral_face_emoji_icon, behaviour = R.string.Behaviour4Answer3),
                Action(icon = R.drawable.smiley_icon, behaviour = R.string.Behaviour4Answer4),
                Action(icon = R.drawable.laugh_icon, behaviour = R.string.Behaviour4Answer5),
            )
        ),
    )
}