package com.dragonfruit.litrosdeagua.data


import com.dragonfruit.litrosdeagua.R

object BehaviourList {
    val wasteBehaviours = listOf(
        Behaviour(
            title = R.string.Recycle,
            actionList = listOf(
                Action(icon = R.drawable.sad_icon, behaviour = R.string.RecycleNo, waterConsumed = 2.2F),
                Action(icon = R.drawable.laugh_icon, behaviour = R.string.RecycleYes, waterConsumed = 1.1F),
            ),
            waterConsumed = 0F,
        ),
        Behaviour(
            title = R.string.TrashBehaviour1,
            actionList = listOf(
                Action(icon = R.drawable.sad_icon, behaviour = R.string.TrashBehaviour1Answer1, waterConsumed = 5.5F),
                Action(icon = R.drawable.angry_icon, behaviour = R.string.TrashBehaviour1Answer2, waterConsumed = 4.4F),
                Action(icon = R.drawable.neutral_face_emoji_icon, behaviour = R.string.TrashBehaviour1Answer3, waterConsumed = 3.4F),
                Action(icon = R.drawable.smiley_icon, behaviour = R.string.TrashBehaviour1Answer4, waterConsumed = 2.2F),
                Action(icon = R.drawable.laugh_icon, behaviour = R.string.TrashBehaviour1Answer5, waterConsumed = 1.1F),
            ),
            waterConsumed = 0F,
        ),
        Behaviour(
            title = R.string.TrashBehaviour2,
            actionList = listOf(
                Action(icon = R.drawable.sad_icon, behaviour = R.string.TrashBehaviour2Answer1, waterConsumed = 5.5F),
                Action(icon = R.drawable.angry_icon, behaviour = R.string.TrashBehaviour2Answer2, waterConsumed = 4.5F),
                Action(icon = R.drawable.neutral_face_emoji_icon, behaviour = R.string.TrashBehaviour2Answer3, waterConsumed = 3.5F),
                Action(icon = R.drawable.smiley_icon, behaviour = R.string.TrashBehaviour2Answer4, waterConsumed = 2.5F),
                Action(icon = R.drawable.laugh_icon, behaviour = R.string.TrashBehaviour2Answer5, waterConsumed = 1.5F),
            ),
            waterConsumed = 0F,
        ),
        Behaviour(
            title = R.string.TrashSeparate,
            actionList = listOf(
                Action(icon = R.drawable.sad_icon, behaviour = R.string.TrashSeparateNo,  waterConsumed = 2.2F),
                Action(icon = R.drawable.laugh_icon, behaviour = R.string.TrashSeparateYes,  waterConsumed = 1.1F),
            ),
            waterConsumed = 0F,
        ),
        Behaviour(
            title = R.string.Behaviour3,
            actionList = listOf(
                Action(icon = R.drawable.sad_icon, behaviour = R.string.TrashBehaviour3Answer1, waterConsumed = 5.5F),
                Action(icon = R.drawable.angry_icon, behaviour = R.string.TrashBehaviour3Answer2, waterConsumed = 4.5F),
                Action(icon = R.drawable.neutral_face_emoji_icon, behaviour = R.string.TrashBehaviour3Answer3, waterConsumed = 3.5F),
                Action(icon = R.drawable.smiley_icon, behaviour = R.string.TrashBehaviour3Answer4, waterConsumed = 2.5F),
                Action(icon = R.drawable.laugh_icon, behaviour = R.string.TrashBehaviour3Answer5, waterConsumed = 1.5F),
            ),
            waterConsumed = 0F,
        ),
        Behaviour(
            title = R.string.Behaviour4,
            actionList = listOf(
                Action(icon = R.drawable.sad_icon, behaviour = R.string.TrashBehaviour4Answer1, waterConsumed = 5.5F),
                Action(icon = R.drawable.angry_icon, behaviour = R.string.TrashBehaviour4Answer2, waterConsumed = 4.5F),
                Action(icon = R.drawable.neutral_face_emoji_icon, behaviour = R.string.TrashBehaviour4Answer3, waterConsumed = 3.5F),
                Action(icon = R.drawable.smiley_icon, behaviour = R.string.TrashBehaviour4Answer4, waterConsumed = 2.5F),
                Action(icon = R.drawable.laugh_icon, behaviour = R.string.TrashBehaviour4Answer5, waterConsumed = 1.5F),
            ),
            waterConsumed = 0F,
        ),
    )
    val waterBehaviours = listOf(
        Behaviour(
            title = R.string.ShowerTime,
            actionList = listOf(
                Action(icon = R.drawable.sad_icon, behaviour = R.string.MoreThanTenMinutes, waterConsumed = 2.2F),
                Action(icon = R.drawable.laugh_icon, behaviour = R.string.TenMinutes, waterConsumed = 1.1F),
            ),
            waterConsumed = 0F,
        ),
        Behaviour(
            title = R.string.Behaviour1,
            actionList = listOf(
                Action(icon = R.drawable.sad_icon, behaviour = R.string.Behaviour1Answer1, waterConsumed = 5.5F),
                Action(icon = R.drawable.angry_icon, behaviour = R.string.Behaviour1Answer2, waterConsumed = 4.4F),
                Action(icon = R.drawable.neutral_face_emoji_icon, behaviour = R.string.Behaviour1Answer3, waterConsumed = 3.4F),
                Action(icon = R.drawable.smiley_icon, behaviour = R.string.Behaviour1Answer4, waterConsumed = 2.2F),
                Action(icon = R.drawable.laugh_icon, behaviour = R.string.Behaviour1Answer5, waterConsumed = 1.1F),
            ),
            waterConsumed = 0F,
        ),
        Behaviour(
            title = R.string.Behaviour2,
            actionList = listOf(
                Action(icon = R.drawable.sad_icon, behaviour = R.string.Behaviour2Answer1, waterConsumed = 5.5F),
                Action(icon = R.drawable.angry_icon, behaviour = R.string.Behaviour2Answer2, waterConsumed = 4.5F),
                Action(icon = R.drawable.neutral_face_emoji_icon, behaviour = R.string.Behaviour2Answer3, waterConsumed = 3.5F),
                Action(icon = R.drawable.smiley_icon, behaviour = R.string.Behaviour2Answer4, waterConsumed = 2.5F),
                Action(icon = R.drawable.laugh_icon, behaviour = R.string.Behaviour2Answer5, waterConsumed = 1.5F),
            ),
            waterConsumed = 0F,
        ),
        Behaviour(
            title = R.string.BottledWater,
            actionList = listOf(
                Action(icon = R.drawable.sad_icon, behaviour = R.string.BottledWaterNo,  waterConsumed = 2.2F),
                Action(icon = R.drawable.laugh_icon, behaviour = R.string.BottledWaterYes,  waterConsumed = 1.1F),
            ),
            waterConsumed = 0F,
        ),
        Behaviour(
            title = R.string.Behaviour3,
            actionList = listOf(
                Action(icon = R.drawable.sad_icon, behaviour = R.string.Behaviour3Answer1, waterConsumed = 5.5F),
                Action(icon = R.drawable.angry_icon, behaviour = R.string.Behaviour3Answer2, waterConsumed = 4.5F),
                Action(icon = R.drawable.neutral_face_emoji_icon, behaviour = R.string.Behaviour3Answer3, waterConsumed = 3.5F),
                Action(icon = R.drawable.smiley_icon, behaviour = R.string.Behaviour3Answer4, waterConsumed = 2.5F),
                Action(icon = R.drawable.laugh_icon, behaviour = R.string.Behaviour3Answer5, waterConsumed = 1.5F),
            ),
            waterConsumed = 0F,
        ),
        Behaviour(
            title = R.string.Behaviour4,
            actionList = listOf(
                Action(icon = R.drawable.sad_icon, behaviour = R.string.Behaviour4Answer1, waterConsumed = 5.5F),
                Action(icon = R.drawable.angry_icon, behaviour = R.string.Behaviour4Answer2, waterConsumed = 4.5F),
                Action(icon = R.drawable.neutral_face_emoji_icon, behaviour = R.string.Behaviour4Answer3, waterConsumed = 3.5F),
                Action(icon = R.drawable.smiley_icon, behaviour = R.string.Behaviour4Answer4, waterConsumed = 2.5F),
                Action(icon = R.drawable.laugh_icon, behaviour = R.string.Behaviour4Answer5, waterConsumed = 1.5F),
            ),
            waterConsumed = 0F,
        ),
    )

}