package com.salehere.salehereexam.domain.goal.mapper

import com.salehere.salehereexam.data.goal.model.CategoryResponse
import com.salehere.salehereexam.data.goal.model.GoalScreenResponse
import com.salehere.salehereexam.domain.goal.model.CategoryModel
import com.salehere.salehereexam.domain.goal.model.GoalScreenModel

fun GoalScreenResponse.toGoalModel(): GoalScreenModel {
    return GoalScreenModel(
        categories = categories?.map { it.toCategoryModel() }
    )
}

fun CategoryResponse.toCategoryModel(): CategoryModel {
    return CategoryModel(
        img = img,
        name = name
    )
}