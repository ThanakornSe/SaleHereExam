package com.salehere.salehereexam.domain.achievement.model

data class AchievementModel(
    val item: List<AchievementItemModel>? = null
)

data class AchievementItemModel(
    val name: String? = null,
    val icon: Int? = null,
)
