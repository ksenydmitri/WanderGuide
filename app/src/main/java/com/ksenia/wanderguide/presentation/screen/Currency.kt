package com.ksenia.wanderguide.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.ksenia.wanderguide.presentation.viewModel.CurrencyViewModel

@Composable
fun CurrencyScreen(nanController: NavController){

    Column {
        AmountInputField()
    }
}

@Composable
fun AmountInputField(viewModel: CurrencyViewModel = viewModel()) {
    val amount = viewModel.amount.value

    TextField(
        value = amount ?: "",
        onValueChange = { viewModel.onAmountChanged(it) },
        label = { Text("Введите сумму") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f)
            .padding(16.dp)
    )
}