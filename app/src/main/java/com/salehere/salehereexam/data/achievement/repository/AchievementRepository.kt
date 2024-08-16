package com.salehere.salehereexam.data.achievement.repository

import com.salehere.salehereexam.data.achievement.model.AchievementResponse
import kotlinx.coroutines.flow.Flow

interface AchievementRepository {
    fun getAchievementData(): Flow<AchievementResponse>
}