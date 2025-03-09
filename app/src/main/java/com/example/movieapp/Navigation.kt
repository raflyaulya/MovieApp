package com.example.movieapp

//import com.example.movieapp.ui.screens.HomeScreen
//import com.example.movieapp.ui.screens.SignUpScreen

// Navigation.kt
sealed class Screen(val route: String) {
    object Movies : Screen("movies")
    object Downloads : Screen("downloads")
    object MovieDetail : Screen("movie_detail/{movieId}")
    object Episodes : Screen("episodes/{seriesId}")
    object MoreMovies : Screen("more_movies")
    object ForgotPassword : Screen("forgot_password")
    object Watchlist : Screen("watchlist")
}