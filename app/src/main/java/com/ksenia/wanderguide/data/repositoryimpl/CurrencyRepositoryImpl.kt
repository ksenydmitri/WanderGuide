package com.ksenia.wanderguide.data.repositoryimpl

import com.ksenia.wanderguide.data.datasource.local.CurrencyDao
import com.ksenia.wanderguide.data.datasource.remote.CurrencyApi
import com.ksenia.wanderguide.data.model.entity.CurrencyRateEntity
import com.ksenia.wanderguide.domain.model.CurrencyRate
import com.ksenia.wanderguide.domain.repository.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import java.time.LocalDateTime
import javax.inject.Inject

class CurrencyRepositoryImpl@Inject constructor(
    private val api: CurrencyApi,
    private val dao: CurrencyDao
) : CurrencyRepository {

    override fun getCurrencyRates(): Flow<List<CurrencyRate>> {
        return dao.getRatesFlow()
            .map { entities -> entities.map{ it ->
                CurrencyRate(
                    rateToBase = it.rate,
                    code = it.currency
                )
            } }
    }

    override suspend fun refreshRatesFromApi() {
        val response = api.getRates()
        val entities = response.currencyRates.map { (rateToBase, code) ->
            CurrencyRateEntity(
                currency = code,
                rate = rateToBase,
                date = LocalDateTime.now().toString())
        }
        dao.insertRates(entities)
    }
}