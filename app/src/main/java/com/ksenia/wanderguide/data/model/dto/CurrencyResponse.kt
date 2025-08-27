package com.ksenia.wanderguide.data.model.dto

import com.ksenia.wanderguide.domain.model.CurrencyRate

data class CurrencyResponse(
    val base: String,
    val date: String,
    val currencyRates: List<CurrencyRate>
)
