package com.salehere.salehereexam.data.home.di

import com.salehere.salehereexam.data.home.repository.HomeRepository
import com.salehere.salehereexam.data.home.repository.HomeRepositoryImpl
import org.koin.dsl.module

val homeDataModule = module {
    single<HomeRepository> { HomeRepositoryImpl() }
}