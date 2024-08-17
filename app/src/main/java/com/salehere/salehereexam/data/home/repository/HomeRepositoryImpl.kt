package com.salehere.salehereexam.data.home.repository

import com.salehere.salehereexam.R
import com.salehere.salehereexam.data.home.model.BestOfferResponse
import com.salehere.salehereexam.data.home.model.GoalResponse
import com.salehere.salehereexam.data.home.model.HomeDataResponse
import com.salehere.salehereexam.data.home.model.SuggestionResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepositoryImpl : HomeRepository {
    override fun getHomeData(): Flow<HomeDataResponse> = flow {
        val responseData = HomeDataResponse(
            goals = listOf(
                GoalResponse(
                    saving = "16,500",
                    goalSaving = "20,000",
                    icon = R.drawable.ic_luggage,
                    name = "ไปเที่ยวญี่ปุ่น",
                    status = "Good",
                    expired = "45"
                ),
                GoalResponse(
                    saving = "500",
                    goalSaving = "6,000",
                    icon = R.drawable.ic_stock,
                    name = "ซื้อกองทุนรวม",
                    status = "Unhappy",
                    expired = "20"
                ),
                GoalResponse(
                    saving = "4,000",
                    goalSaving = "5,000",
                    icon = R.drawable.ic_luggage,
                    name = "ไปทะเล",
                    status = "Good",
                    expired = "10"
                )
            ),
            allSaving = "37,500",
            bestOffers = listOf(
                BestOfferResponse(
                    img = R.drawable.img_best_offer_1
                ),
                BestOfferResponse(
                    img = R.drawable.img_best_offer_2
                ),
                BestOfferResponse(
                    img = R.drawable.img_best_offer_3
                )
            ),
            suggestions = listOf(
                SuggestionResponse(
                    img = R.drawable.img_suggest_1
                ),
                SuggestionResponse(
                    img = R.drawable.img_suggest_2
                ),
                SuggestionResponse(
                    img = R.drawable.img_suggest_3
                )
            )
        )
        emit(responseData)
    }
}