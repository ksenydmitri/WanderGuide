package com.ksenia.wanderguide.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ksenia.wanderguide.domain.model.CurrencyAmount
import com.ksenia.wanderguide.domain.model.CurrencyRate
import com.ksenia.wanderguide.domain.repository.CurrencyRepository
import com.ksenia.wanderguide.domain.usecase.ConvertCurrencyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyViewModel @Inject constructor(
    private val convertCurrencyUseCase: ConvertCurrencyUseCase,
    private val repository: CurrencyRepository
) : ViewModel() {

    val rates: StateFlow<List<CurrencyRate>> = repository.getCurrencyRates()
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())
    private val _activeCurrencyCode = MutableStateFlow("USD")
    private val _inputAmount = MutableStateFlow(0.0)

    /*init {
        refreshRates()
    }*/

    val convertedAmounts: StateFlow<List<CurrencyAmount>> =
        combine(rates, _activeCurrencyCode, _inputAmount) { rates, code, amount ->
            convertCurrencyUseCase.execute(amount, code, rates)
        }.stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    fun onAmountChanged(code: String, amount: Double) {
        _activeCurrencyCode.value = code
        _inputAmount.value = amount
    }

    fun refreshRates() {
        viewModelScope.launch {

        }
    }

}