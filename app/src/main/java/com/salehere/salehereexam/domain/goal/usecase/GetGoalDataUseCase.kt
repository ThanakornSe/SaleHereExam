package com.salehere.salehereexam.domain.goal.usecase

import com.salehere.salehereexam.data.goal.repository.GoalRepository
import com.salehere.salehereexam.domain.goal.mapper.toGoalModel
import com.salehere.salehereexam.domain.goal.model.GoalScreenModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetGoalDataUseCase(private val repository: GoalRepository) {
    fun execute(): Flow<GoalScreenModel> {
        return repository.getGoalData().map { response ->
            response.toGoalModel()
        }
    }
}