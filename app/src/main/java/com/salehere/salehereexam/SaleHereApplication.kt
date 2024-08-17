package com.salehere.salehereexam

import android.app.Application
import com.salehere.salehereexam.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SaleHereApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SaleHereApplication)
            modules(appModule)
        }
    }
}