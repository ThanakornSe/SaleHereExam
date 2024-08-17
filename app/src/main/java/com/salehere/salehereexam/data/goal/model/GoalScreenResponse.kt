package com.salehere.salehereexam.data.goal.model

data class GoalScreenResponse(
    val categories: List<CategoryResponse>? = null
)

data class CategoryResponse(
    val img: Int? = null,
    val name: String? = null,
)