package com.salehere.salehereexam.domain.home.model

data class HomeModel(
    val goals: List<GoalModel>? = null,
    val allSaving: String? = null,
    val bestOffers: List<BestOfferModel>? = null,
    val suggestions: List<SuggestionModel>? = null,
)

data class GoalModel(
    val saving: String? = null,
    val goalSaving: String? = null,
    val Icon: Int? = null,
    val name: String? = null,
    val status: String? = null,
    val expired: String? = null,
)

data class BestOfferModel(
    val img:Int? = null
)

data class SuggestionModel(
    val img:Int? = null
)