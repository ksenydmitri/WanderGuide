package com.ksenia.wanderguide.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ksenia.wanderguide.presentation.screen.CurrencyScreen
import com.ksenia.wanderguide.presentation.screen.HomeScreen
import com.ksenia.wanderguide.presentation.screen.MapScreen
import com.ksenia.wanderguide.presentation.screen.MenuScreen

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Menu.route
    ) {
        composable(Screen.Menu.route) {
            MenuScreen(navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Map.route) {
            MapScreen(navController)
        }
        composable(Screen.Currency.route) {
            CurrencyScreen(navController)
        }
    }
}