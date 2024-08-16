package com.salehere.salehereexam.domain.home.usecase

import com.salehere.salehereexam.data.home.repository.HomeRepository
import com.salehere.salehereexam.domain.home.mapper.toHomeModel
import com.salehere.salehereexam.domain.home.model.HomeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetHomeDataUseCase(private val repository: HomeRepository) {
    fun getHomeData(): Flow<HomeModel> {
        return repository.getHomeData().map { response ->
            response.toHomeModel()
        }
    }
}