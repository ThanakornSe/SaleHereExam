package com.salehere.salehereexam.data.achievement.repository

import com.salehere.salehereexam.R
import com.salehere.salehereexam.data.achievement.model.AchievementItemResponse
import com.salehere.salehereexam.data.achievement.model.AchievementResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AchievementRepositoryImpl : AchievementRepository {
    override fun getAchievementData(): Flow<AchievementResponse> {
        return flow {
            val dataResponse = AchievementResponse(
                item = listOf(
                    AchievementItemResponse(
                        name = "Achievement", icon = R.drawable.ic_achievement
                    ),
                    AchievementItemResponse(
                        name = "Achievement", icon = R.drawable.ic_achievement
                    ),
                    AchievementItemResponse(
                        name = "Achievement", icon = R.drawable.ic_achievement
                    ),
                    AchievementItemResponse(
                        name = "Achievement", icon = R.drawable.ic_achievement
                    ),
                    AchievementItemResponse(
                        name = "Achievement", icon = R.drawable.ic_achievement
                    ),
                    AchievementItemResponse(
                        name = "Achievement", icon = R.drawable.ic_achievement
                    ),
                    AchievementItemResponse(
                        name = "Achievement", icon = R.drawable.ic_achievement
                    )
                )
            )
            emit(dataResponse)
        }
    }
}