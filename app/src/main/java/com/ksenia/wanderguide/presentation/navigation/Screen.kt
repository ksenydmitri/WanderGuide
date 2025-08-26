package com.ksenia.wanderguide.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : Screen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Menu : Screen(
        route = "menu",
        title = "Menu",
        icon = Icons.Default.Menu
    )

    object Map : Screen(
        route = "map",
        title = "Maps",
        icon = Icons.Default.Place
    )

    object Currency : Screen(
        route = "currency",
        title = "Конвентер",
        icon = Icons.Default.Share
    )

    object Notes : Screen(
        route = "notes",
        title = "Заметки",
        icon =  Icons.Default.Done
    )

    companion object {
        val MenuItems: List<Screen> by lazy {
            listOf(Home, Menu, Map, Currency, Notes).also {
                require(it.all { item -> item.title.isNotBlank() }) {
                    "Все элементы меню должны иметь title"
                }
            }
        }
    }
}