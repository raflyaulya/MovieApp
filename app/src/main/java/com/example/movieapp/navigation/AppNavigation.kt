package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import com.example.movieapp.ui.screens.HomeScreen
//import com.example.movieapp.ui.screens.SignUpScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "movieList") {
//        composable("movieList") { SignUpScreen(navController) }
        composable("movieDetail/{movieId}") { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")?.toIntOrNull() ?: 0
//            HomeScreen(movieId)
        }
    }
}