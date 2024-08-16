package com.salehere.salehereexam.ui.achievement.di

import com.salehere.salehereexam.data.achievement.di.achievementDataModule
import com.salehere.salehereexam.domain.achievement.di.achievementDomainModule
import com.salehere.salehereexam.ui.achievement.viewmodel.AchievementViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val achievementFeatureModule = module {
    includes(achievementDataModule)
    includes(achievementDomainModule)
    viewModel { AchievementViewModel(get(), get()) }
}