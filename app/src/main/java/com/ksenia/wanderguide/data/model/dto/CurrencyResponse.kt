package com.ksenia.wanderguide.data.model.dto

data class CurrencyResponse(
    val base: String,
    val date: String,
    val rates: Map<String, Double>
)
