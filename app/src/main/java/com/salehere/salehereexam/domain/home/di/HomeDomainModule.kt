package com.salehere.salehereexam.domain.home.di

import com.salehere.salehereexam.data.home.di.homeDataModule
import com.salehere.salehereexam.domain.home.usecase.GetHomeDataUseCase
import org.koin.dsl.module

val homeDomainModule = module {
    includes(homeDataModule)
    single { GetHomeDataUseCase(get()) }
}