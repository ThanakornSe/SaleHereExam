package com.salehere.salehereexam

import android.app.Application
import org.koin.core.context.startKoin

class SaleHereApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {  }
    }
}