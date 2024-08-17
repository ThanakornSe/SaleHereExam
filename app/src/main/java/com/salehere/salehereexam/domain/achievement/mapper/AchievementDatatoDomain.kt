package com.salehere.salehereexam.domain.achievement.mapper

import com.salehere.salehereexam.data.achievement.model.AchievementItemResponse
import com.salehere.salehereexam.data.achievement.model.AchievementResponse
import com.salehere.salehereexam.domain.achievement.model.AchievementItemModel
import com.salehere.salehereexam.domain.achievement.model.AchievementModel

fun AchievementResponse.toAchievementModel(): AchievementModel =
    AchievementModel(
        item = item?.map {
            it.toAchievementItemModel()
        }
    )


fun AchievementItemResponse.toAchievementItemModel(): AchievementItemModel =
    AchievementItemModel(
        name = name,
        icon = icon
    )