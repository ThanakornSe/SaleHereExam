package com.salehere.salehereexam.ui.goal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salehere.salehereexam.core.dispatcher.DispatcherProviders
import com.salehere.salehereexam.domain.goal.usecase.GetGoalDataUseCase
import com.salehere.salehereexam.ui.goal.model.Category
import com.salehere.salehereexam.ui.goal.model.GoalScreenUiState
import com.salehere.salehereexam.ui.home.mapper.toHomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

class GoalViewModel(
    private val useCase: GetGoalDataUseCase,
    private val dispatcher: DispatcherProviders,
) : ViewModel() {
    private val _uiState = MutableStateFlow(GoalScreenUiState())
    val uiState: StateFlow<GoalScreenUiState> = _uiState.asStateFlow()

    fun getGoalData() {
        useCase.execute().flowOn(dispatcher.io).onEach {
            _uiState.update {  currentState ->
                currentState.copy(
                    categories = it.categories?.map { Category(it.img, it.name) }
                )
            }
        }.launchIn(viewModelScope)
    }

}