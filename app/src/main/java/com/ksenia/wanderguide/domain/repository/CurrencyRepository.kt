package com.ksenia.wanderguide.domain.repository

import com.ksenia.wanderguide.domain.model.CurrencyRate
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {
    fun getCurrencyRates(): Flow<List<CurrencyRate>>
    suspend fun refreshRatesFromApi()
}