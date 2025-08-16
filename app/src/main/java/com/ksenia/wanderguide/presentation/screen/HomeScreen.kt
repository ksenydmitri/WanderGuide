package com.ksenia.wanderguide.presentation.screen

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Text("Главный экран", style = MaterialTheme.typography.headlineMedium)
}