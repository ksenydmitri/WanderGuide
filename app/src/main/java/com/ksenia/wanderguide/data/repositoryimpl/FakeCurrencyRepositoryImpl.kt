package com.ksenia.wanderguide.data.repositoryimpl

import com.ksenia.wanderguide.data.datasource.local.CurrencyDao
import com.ksenia.wanderguide.data.datasource.remote.CurrencyApi
import com.ksenia.wanderguide.domain.model.CurrencyRate
import com.ksenia.wanderguide.domain.repository.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FakeCurrencyRepositoryImpl@Inject constructor(
    private val api: CurrencyApi,
    private val dao: CurrencyDao
) : CurrencyRepository {
    override fun getCurrencyRates(): Flow<List<CurrencyRate>> = flow {
        emit(
            listOf(
                CurrencyRate(1.0, "USD"),
                CurrencyRate(0.92,  "EUR"),
                CurrencyRate(145.0, "JPY"),
                CurrencyRate(3.2, "BYN"),
                CurrencyRate(27000.0, "BTC")
            )
        )
    }

    override suspend fun refreshRatesFromApi() {
        TODO("Not yet implemented")
    }

}