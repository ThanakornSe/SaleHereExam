package com.salehere.salehereexam.data.achievement.model

data class AchievementResponse(
    val item: List<AchievementItemResponse>? = null
)

data class AchievementItemResponse(
    val name: String? = null,
    val icon: Int? = null,
)
