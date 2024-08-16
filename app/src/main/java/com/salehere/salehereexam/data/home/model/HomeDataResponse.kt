package com.salehere.salehereexam.data.home.model

data class HomeDataResponse(
    val goals: List<GoalResponse>? = null,
    val allSaving: String? = null,
    val bestOffers: List<BestOfferResponse>? = null,
    val suggestions: List<SuggestionResponse>? = null,
)

data class GoalResponse(
    val saving: String? = null,
    val goalSaving: String? = null,
    val icon: Int? = null,
    val name: String? = null,
    val status: String? = null,
    val expired: String? = null,
)

data class BestOfferResponse(
    val img:Int? = null
)

data class SuggestionResponse(
    val img:Int? = null
)