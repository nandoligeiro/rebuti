package com.nandoligeiro.ituber.presentation

import DetailScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nandoligeiro.ituber.R
import com.nandoligeiro.ituber.presentation.common.moshi
import com.nandoligeiro.ituber.presentation.screen.home.HomeScreen
import com.nandoligeiro.ituber.presentation.screen.home.model.PopularMovieResultUi

@Composable
fun NavigationApp() {
    val navController = rememberNavController()
    val context = LocalContext.current

    NavHost(navController = navController, startDestination = stringResource(R.string.nav_home)) {
        composable(context.getString(R.string.nav_home)) {
            HomeScreen(navController = navController)
        }
        composable(
            context.getString(R.string.nav_details_movie),
            arguments = listOf(navArgument(context.getString(R.string.arg_movie)) {
                type = NavType.StringType
            })
        ) { backStackEntry ->

            val movieJson =
                backStackEntry.arguments?.getString(context.getString(R.string.arg_movie))
            val movie =
                movieJson?.let { moshi.adapter(PopularMovieResultUi::class.java).fromJson(it) }
            movie?.let {
                DetailScreen(movie = it, onBackClick = { navController.popBackStack() })
            }
        }
    }
}
