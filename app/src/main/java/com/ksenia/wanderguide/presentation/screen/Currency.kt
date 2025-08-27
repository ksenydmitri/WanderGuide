package com.ksenia.wanderguide.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ksenia.wanderguide.domain.model.CurrencyRate
import com.ksenia.wanderguide.presentation.viewModel.CurrencyViewModel
import java.nio.file.WatchEvent

@Composable
fun CurrencyScreen(nanController: NavController){
    val viewModel: CurrencyViewModel = hiltViewModel()

    var selectedCurrency by remember { mutableStateOf("USD") }
    var amount by remember { mutableStateOf("1.0") }

    val rates by viewModel.rates.collectAsState()
    val convertedRates = rates.map {
        val baseRate = rates.find { it.code == selectedCurrency }?.rateToBase ?: 1.0
        val inputAmount = amount.toDoubleOrNull() ?: 1.0
        val converted = inputAmount * it.rateToBase / baseRate
        it.copy(rateToBase = converted)
    }
    Column {
        TextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Сумма в $selectedCurrency") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        LazyColumn {
            items(convertedRates.size) { index ->
                RateListItem(
                    currencyCode = convertedRates[index].code,
                    rate = convertedRates[index].rateToBase,
                    isSelected = convertedRates[index].code == selectedCurrency,
                    onClick = { selectedCurrency = convertedRates[index].code }
                )
            }
        }
    }

}

@Composable
fun RateListItem(currencyCode: String,
                 rate: Double,
                 isSelected: Boolean,
                 onClick: (() -> Unit)? = null,
                 onChange: ((String) -> Unit)? = null) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp)

        ) {
            Text(
                currencyCode,
                modifier = Modifier
                    .size(20.dp),
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
            Text(rate.toString())
        }
    }
}