package com.salehere.salehereexam.data.goal.repository

import com.salehere.salehereexam.data.goal.model.GoalScreenResponse
import kotlinx.coroutines.flow.Flow

interface GoalRepository {
    fun getGoalData(): Flow<GoalScreenResponse>
}