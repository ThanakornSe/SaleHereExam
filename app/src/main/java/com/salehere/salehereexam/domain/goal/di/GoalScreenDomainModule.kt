package com.salehere.salehereexam.domain.goal.di

import com.salehere.salehereexam.data.goal.di.goalDataModule
import com.salehere.salehereexam.domain.goal.usecase.GetGoalDataUseCase
import org.koin.dsl.module

val goalDomainModule = module {
    includes(goalDataModule)
    single { GetGoalDataUseCase(get()) }
}