package com.salehere.salehereexam.data.goal.di

import com.salehere.salehereexam.data.goal.repository.GoalRepository
import com.salehere.salehereexam.data.goal.repository.GoalRepositoryImpl
import org.koin.dsl.module

val goalDataModule = module {
    single<GoalRepository> { GoalRepositoryImpl() }
}