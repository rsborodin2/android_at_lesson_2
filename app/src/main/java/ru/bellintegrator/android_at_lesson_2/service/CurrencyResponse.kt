package ru.bellintegrator.android_at_lesson_2.service

data class CurrencyResponse(
    val rates: Map<String, Double>,
    val base: String,
    val date: String
)