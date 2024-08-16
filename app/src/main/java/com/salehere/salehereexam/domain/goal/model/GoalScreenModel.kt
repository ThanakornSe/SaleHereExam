package com.salehere.salehereexam.domain.goal.model

data class GoalScreenModel(
    val categories: List<CategoryModel>? = null
)

data class CategoryModel(
    val img: Int? = null,
    val name: String? = null,
)