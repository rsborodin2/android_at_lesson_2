package ru.bellintegrator.android_at_lesson_2.service

import retrofit2.Response
import retrofit2.http.GET

interface CurrencyApiService {
    @GET("latest.json?app_id=e8a56c09157c4b6eb593875881a2d1ee")
    suspend fun getLatestRates(): Response<CurrencyResponse>

}