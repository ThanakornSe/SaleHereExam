package com.salehere.salehereexam.domain.home.mapper

import com.salehere.salehereexam.data.home.model.BestOfferResponse
import com.salehere.salehereexam.data.home.model.GoalResponse
import com.salehere.salehereexam.data.home.model.HomeDataResponse
import com.salehere.salehereexam.data.home.model.SuggestionResponse
import com.salehere.salehereexam.domain.home.model.BestOfferModel
import com.salehere.salehereexam.domain.home.model.GoalModel
import com.salehere.salehereexam.domain.home.model.HomeModel
import com.salehere.salehereexam.domain.home.model.SuggestionModel

fun HomeDataResponse.toHomeModel() = HomeModel(
    goals = goals?.map { it.toGoalModel() },
    allSaving = allSaving,
    bestOffers = bestOffers?.map { it.toBestOfferModel() },
    suggestions = suggestions?.map { it.toSuggestionModel() },
)

fun GoalResponse.toGoalModel() = GoalModel(
    saving = saving,
    goalSaving = goalSaving,
    Icon = icon,
    name = name,
    status = status,
    expired = expired,
)

fun BestOfferResponse.toBestOfferModel() = BestOfferModel(
    img = img
)

fun SuggestionResponse.toSuggestionModel() = SuggestionModel(
    img = img
)