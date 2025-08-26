package com.ksenia.wanderguide.presentation.viewModel

import android.icu.util.CurrencyAmount
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ksenia.wanderguide.domain.repository.CurrencyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyViewModel@Inject constructor(
    private val repository: CurrencyRepository) : ViewModel() {

    val amount = MutableLiveData<String>()
    val rates = MutableLiveData<Map<String, Double>>()

    fun loadRates(base: String) {
        viewModelScope.launch {
            val result = repository.fetchRates(base)
            rates.postValue(result)
        }
    }

    fun convert(amount: Double, targetCurrency: String): Double {
        val rate = rates.value?.get(targetCurrency) ?: 1.0
        return amount * rate
    }

    fun onAmountChanged(newAmount: String){
        TODO()
    }
}
