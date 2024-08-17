package com.salehere.salehereexam.ui.achievement.model

data class AchievementUiState(
    val item: List<AchievementItem>? = null
)

data class AchievementItem(
    val name: String? = null,
    val icon: Int? = null,
)
