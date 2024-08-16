package com.salehere.salehereexam.ui.goal.di

import com.salehere.salehereexam.ui.goal.viewmodel.GoalViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val goalFeatureModule = module {

    viewModel { GoalViewModel() }
}