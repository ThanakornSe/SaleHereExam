package com.salehere.salehereexam.ui.home.di

import com.salehere.salehereexam.core.dispatcher.DispatcherProviders
import com.salehere.salehereexam.core.dispatcher.DispatcherProvidersImpl
import com.salehere.salehereexam.data.home.di.homeDataModule
import com.salehere.salehereexam.domain.home.di.homeDomainModule
import com.salehere.salehereexam.ui.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeFeatureModule = module {
    includes(homeDataModule)
    includes(homeDomainModule)
    single<DispatcherProviders> { DispatcherProvidersImpl() }
    viewModel { HomeViewModel(get(), get()) }
}