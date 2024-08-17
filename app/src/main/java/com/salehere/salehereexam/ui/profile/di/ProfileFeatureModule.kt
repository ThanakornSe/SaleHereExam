package com.salehere.salehereexam.ui.profile.di

import com.salehere.salehereexam.data.sockethandler.di.socketModule
import com.salehere.salehereexam.ui.profile.viewmodel.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val profileFeatureModule = module {
    includes(socketModule)
    viewModel { ProfileViewModel(get()) }
}