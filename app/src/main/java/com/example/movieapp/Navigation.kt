package com.example.movieapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.ui.screens.MovieScreen
import com.example.movieapp.ui.screens.MovieDetailScreen

sealed class Screen(val route: String) {
    object Movies : Screen("movies")
    object Downloads : Screen("downloads")
    object MovieDetail : Screen("movie_detail/{movieId}")
    object Episodes : Screen("episodes/{seriesId}")
    object MoreMovies : Screen("more_movies")
    object ForgotPassword : Screen("forgot_password")
    object Watchlist : Screen("watchlist") // Pastikan ini ada
}

@Composable
fun MovieAppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Movies.route
    ) {
        composable(Screen.Movies.route) {
            MovieScreen(
                onMovieClick = { movieId ->
                    navController.navigate(Screen.MovieDetail.route.replace("{movieId}", movieId))
                }
            )
        }
        composable(Screen.MovieDetail.route) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId") ?: ""
            MovieDetailScreen(
                movieId = movieId,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}