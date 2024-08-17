package com.salehere.salehereexam.data.sockethandler.di

import com.salehere.salehereexam.data.sockethandler.service.SocketHandler
import com.salehere.salehereexam.data.sockethandler.service.SocketHandlerImpl
import org.koin.dsl.module

val socketModule = module {
    single<SocketHandler> { SocketHandlerImpl() }
}