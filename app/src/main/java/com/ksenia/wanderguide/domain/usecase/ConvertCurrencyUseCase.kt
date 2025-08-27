package com.ksenia.wanderguide.domain.usecase

import com.ksenia.wanderguide.domain.model.CurrencyAmount
import com.ksenia.wanderguide.domain.model.CurrencyRate
import com.ksenia.wanderguide.domain.repository.CurrencyRepository
import javax.inject.Inject
import kotlin.collections.find
import kotlin.collections.map

class ConvertCurrencyUseCase@Inject constructor(
    currencyRepository: CurrencyRepository
) {
    fun execute(
        inputAmount: Double,
        inputCurrencyCode: String,
        currencyRates: List<CurrencyRate>
    ): List<CurrencyAmount> {
        val fromRate = currencyRates.find {
            it.code == inputCurrencyCode }?.rateToBase?: return emptyList()
        val baseAmount = inputAmount / fromRate

        return currencyRates.map { rate ->
            CurrencyAmount(
                code = rate.code,
                amount = baseAmount * rate.rateToBase
            )
        }
    }
}
