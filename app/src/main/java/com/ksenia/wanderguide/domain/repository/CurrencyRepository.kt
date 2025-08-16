package com.ksenia.wanderguide.domain.repository

interface CurrencyRepository {
    suspend fun fetchRates(base: String): Map<String, Double>
}