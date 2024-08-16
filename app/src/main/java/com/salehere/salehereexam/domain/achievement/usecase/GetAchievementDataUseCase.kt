package com.salehere.salehereexam.domain.achievement.usecase

import com.salehere.salehereexam.data.achievement.repository.AchievementRepository
import com.salehere.salehereexam.domain.achievement.mapper.toAchievementModel
import com.salehere.salehereexam.domain.achievement.model.AchievementModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAchievementDataUseCase(private val repository: AchievementRepository) {
    fun execute(): Flow<AchievementModel> {
        return repository.getAchievementData().map { it.toAchievementModel() }
    }
}