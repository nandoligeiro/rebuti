package com.nandoligeiro.ituber.presentation

import DetailScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nandoligeiro.ituber.presentation.screen.Screen
import com.nandoligeiro.ituber.presentation.screen.home.HomeScreen

@Composable
fun NavigationApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument("itemId"){type = NavType.IntType }) )
        { backStackEntry ->

            val id = backStackEntry.arguments?.getInt("itemId")
            if (id != null) {
                DetailScreen(movieId = id, onBackClick = { navController.popBackStack() })
            } else {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Movie ID not found")
                }
            }
        }
    }
}
