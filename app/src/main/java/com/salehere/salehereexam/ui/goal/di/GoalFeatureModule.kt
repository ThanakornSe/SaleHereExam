package com.salehere.salehereexam.ui.goal.di

import com.salehere.salehereexam.data.goal.di.goalDataModule
import com.salehere.salehereexam.domain.goal.di.goalDomainModule
import com.salehere.salehereexam.ui.goal.viewmodel.GoalViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val goalFeatureModule = module {
    includes(goalDataModule)
    includes(goalDomainModule)
    viewModel { GoalViewModel(get(),get()) }
}