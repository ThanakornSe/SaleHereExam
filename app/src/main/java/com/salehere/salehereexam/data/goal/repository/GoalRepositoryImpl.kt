package com.salehere.salehereexam.data.goal.repository

import com.salehere.salehereexam.R
import com.salehere.salehereexam.data.goal.model.CategoryResponse
import com.salehere.salehereexam.data.goal.model.GoalScreenResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GoalRepositoryImpl : GoalRepository {
    override fun getGoalData(): Flow<GoalScreenResponse> = flow {
        val responseData = GoalScreenResponse(
            categories = listOf(
                CategoryResponse(
                    img = R.drawable.ic_luggage, name = "Travel"
                ),
                CategoryResponse(
                    img = R.drawable.ic_education, name = "Education"
                ),
                CategoryResponse(
                    img = R.drawable.ic_stock, name = "Invest"
                ),
                CategoryResponse(
                    img = R.drawable.ic_cloth, name = "Clothing"
                ),
                CategoryResponse(
                    img = R.drawable.ic_education, name = "Education"
                ),
            )
        )
        emit(responseData)
    }
}