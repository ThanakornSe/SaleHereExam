package com.salehere.salehereexam.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salehere.salehereexam.core.dispatcher.DispatcherProviders
import com.salehere.salehereexam.domain.home.usecase.GetHomeDataUseCase
import com.salehere.salehereexam.ui.home.mapper.toHomeUiState
import com.salehere.salehereexam.ui.home.model.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

class HomeViewModel(
    private val useCase: GetHomeDataUseCase,
    private val dispatcher: DispatcherProviders
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun getHomeData() {
        useCase.getHomeData().flowOn(dispatcher.io).onEach {
            val data = it.toHomeUiState()
            _uiState.update {  currentState ->
                currentState.copy(
                    goals = data.goals,
                    allSaving = data.allSaving,
                    bestOffers = data.bestOffers,
                    suggestions = data.suggestions
                )
            }
        }.launchIn(viewModelScope)

    }

}