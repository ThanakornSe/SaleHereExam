package com.salehere.salehereexam.ui.home.mapper

import com.salehere.salehereexam.domain.home.model.BestOfferModel
import com.salehere.salehereexam.domain.home.model.GoalModel
import com.salehere.salehereexam.domain.home.model.HomeModel
import com.salehere.salehereexam.domain.home.model.SuggestionModel
import com.salehere.salehereexam.ui.home.model.BestOffer
import com.salehere.salehereexam.ui.home.model.Goal
import com.salehere.salehereexam.ui.home.model.HomeUiState
import com.salehere.salehereexam.ui.home.model.Suggestion

fun HomeModel.toHomeUiState() = HomeUiState(
    goals = goals?.map { it.toGoal() },
    allSaving = allSaving,
    bestOffers = bestOffers?.map { it.toBestOffer() },
    suggestions = suggestions?.map { it.toSuggestion() },
)

fun GoalModel.toGoal() = Goal(
    saving = saving,
    goalSaving = goalSaving,
    icon = Icon,
    name = name,
    status = status,
    expired = expired,
)

fun BestOfferModel.toBestOffer() = BestOffer(
    img = img
)

fun SuggestionModel.toSuggestion() = Suggestion(
    img = img
)