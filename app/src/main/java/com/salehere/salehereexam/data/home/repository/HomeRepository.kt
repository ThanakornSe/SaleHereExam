package com.salehere.salehereexam.data.home.repository

import com.salehere.salehereexam.data.home.model.HomeDataResponse
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getHomeData(): Flow<HomeDataResponse>
}