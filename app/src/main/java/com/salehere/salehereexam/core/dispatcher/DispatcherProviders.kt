package com.salehere.salehereexam.core.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProviders {
    val default: CoroutineDispatcher
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}
