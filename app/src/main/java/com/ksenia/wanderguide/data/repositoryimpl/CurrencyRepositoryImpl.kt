package com.ksenia.wanderguide.data.repositoryimpl

import com.ksenia.wanderguide.data.datasource.local.CurrencyDao
import com.ksenia.wanderguide.data.datasource.remote.CurrencyApi
import com.ksenia.wanderguide.domain.repository.CurrencyRepository
import javax.inject.Inject

class CurrencyRepositoryImpl@Inject constructor(
    private val dao: CurrencyDao,
    private val api: CurrencyApi
): CurrencyRepository {

    override suspend fun fetchRates(base: String): Map<String, Double> {
        return try {
            val response = api.getRates(base)
            dao.saveRates(response.rates, response.date)
            response.rates
        } catch (e: Exception) {
            dao.getCachedRates()
        }
    }

}