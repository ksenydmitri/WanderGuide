package com.ksenia.wanderguide.domain.repository

import com.ksenia.wanderguide.domain.model.Rate

interface CurrencyRepository {
    suspend fun fetchRates(base: String): List<Rate>
}