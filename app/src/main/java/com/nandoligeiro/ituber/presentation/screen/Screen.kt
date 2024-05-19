package com.nandoligeiro.ituber.presentation.screen

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Details : Screen("details/{itemId}") {
        fun createRoute(itemId: Int) = "details/$itemId"
    }
}