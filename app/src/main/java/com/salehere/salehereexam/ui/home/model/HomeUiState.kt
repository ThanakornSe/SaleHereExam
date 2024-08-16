package com.salehere.salehereexam.ui.home.model

data class HomeUiState(
    val goals: List<Goal>? = null,
    val allSaving: String? = null,
    val bestOffers: List<BestOffer>? = null,
    val suggestions: List<Suggestion>? = null,
)

data class Goal(
    val saving: String? = null,
    val goalSaving: String? = null,
    val icon: Int? = null,
    val name: String? = null,
    val status: String? = null,
    val expired: String? = null,
)

data class BestOffer(
    val img:Int? = null
)

data class Suggestion(
    val img:Int? = null
)