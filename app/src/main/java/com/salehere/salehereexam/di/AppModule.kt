package com.salehere.salehereexam.di

import com.salehere.salehereexam.ui.goal.di.goalFeatureModule
import com.salehere.salehereexam.ui.home.di.homeFeatureModule
import org.koin.dsl.module

val appModule = module {
    includes(homeFeatureModule)
    includes(goalFeatureModule)
}