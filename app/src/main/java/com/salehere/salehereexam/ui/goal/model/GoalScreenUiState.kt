package com.salehere.salehereexam.ui.goal.model

data class GoalScreenUiState(
    val categories: List<Category>? = null
)

data class Category(
    val img: Int? = null,
    val name: String? = null,
)