package com.salehere.salehereexam.domain.achievement.di

import com.salehere.salehereexam.data.achievement.di.achievementDataModule
import com.salehere.salehereexam.domain.achievement.usecase.GetAchievementDataUseCase
import org.koin.dsl.module

val achievementDomainModule = module {
    includes(achievementDataModule)
    single { GetAchievementDataUseCase(get()) }
}