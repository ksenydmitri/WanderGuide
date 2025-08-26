package com.ksenia.wanderguide.data.repositoryimpl

import com.ksenia.wanderguide.data.datasource.local.CurrencyDao
import com.ksenia.wanderguide.data.datasource.remote.CurrencyApi
import com.ksenia.wanderguide.data.model.entity.CurrencyRate
import com.ksenia.wanderguide.domain.model.Rate
import com.ksenia.wanderguide.domain.repository.CurrencyRepository
import java.time.LocalDate
import javax.inject.Inject

class CurrencyRepositoryImpl@Inject constructor(
    private val dao: CurrencyDao,
    private val api: CurrencyApi
): CurrencyRepository {

    override suspend fun fetchRates(base: String): List<Rate> {
        return try {
            val response = api.getRates(base)
            val entityList = response.rates.map { (currency, rate) ->
                CurrencyRate(
                    currency = currency,
                    rate = rate,
                    date = LocalDate.now().toString())
            }
            dao.saveRates(entityList)
            response.rates.map { (currency, rate)  ->
                Rate(
                    currency = rate,
                    code = currency
                )
            }
        } catch (e: Exception) {
            dao.getCachedRates().map { entry ->
                Rate(
                    currency = entry.rate,
                    code = entry.currency
                )
            }
        }
    }

}