package com.salehere.salehereexam.ui.achievement.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salehere.salehereexam.core.dispatcher.DispatcherProviders
import com.salehere.salehereexam.domain.achievement.usecase.GetAchievementDataUseCase
import com.salehere.salehereexam.ui.achievement.model.AchievementItem
import com.salehere.salehereexam.ui.achievement.model.AchievementUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

class AchievementViewModel(
    private val useCase: GetAchievementDataUseCase,
    private val dispatcher: DispatcherProviders,
) : ViewModel() {
    private val _uiState = MutableStateFlow(AchievementUiState())
    val uiState: StateFlow<AchievementUiState> = _uiState.asStateFlow()

    fun getAchievementData() {
        useCase.execute().flowOn(dispatcher.io).onEach {
            _uiState.update {  currentState ->
                currentState.copy(
                    item = it.item?.map { item -> AchievementItem(item.name, item.icon) }
                )
            }
        }.launchIn(viewModelScope)
    }
}