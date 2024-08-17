package com.salehere.salehereexam.data.achievement.di

import com.salehere.salehereexam.data.achievement.repository.AchievementRepository
import com.salehere.salehereexam.data.achievement.repository.AchievementRepositoryImpl
import org.koin.dsl.module

val achievementDataModule = module {
    single<AchievementRepository> { AchievementRepositoryImpl() }
}