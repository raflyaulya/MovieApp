package com.example.movieapp

import MovieAppBottomNavigation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.*
import com.example.movieapp.ui.screens.CategoriesScreen
import com.example.movieapp.ui.screens.DownloadsScreen
import com.example.movieapp.ui.screens.EpisodesScreen
import com.example.movieapp.ui.screens.ForgotPasswordScreen
import com.example.movieapp.ui.screens.MoreMoviesScreen
import com.example.movieapp.ui.screens.MovieDetailScreen
import com.example.movieapp.ui.screens.MoviesScreen
import com.example.movieapp.ui.screens.UserSelectionScreen
import com.example.movieapp.ui.theme.MovieAppTheme
import com.example.movieapp.ui.theme.screens.auth.SignInScreen
import com.example.movieapp.ui.theme.screens.auth.SignUpScreen

//import com.example.movieapp.ui.screens.GenresCategoriesScreen

// MainActivity.kt
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                MovieApp()
            }
        }
    }
}

@Composable
fun MovieApp() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route ?: Screen.Movies.route

    Scaffold(
        bottomBar = {
            MovieAppBottomNavigation(
                currentRoute = currentRoute,
                onNavigate = { route ->
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Movies.route,
            modifier = Modifier.padding(paddingValues)
        )

        {
            // Di dalam NavHost pada MainActivity.kt
            composable("user_selection") {
                UserSelectionScreen(
                    onUserSelect = { userId ->
                        navController.navigate("sign_in")
                    },
                    onCreateAccountClick = {
                        navController.navigate("sign_up")
                    }
                )
            }

            composable("sign_in") {
                SignInScreen(
                    onSignInClick = {
                        navController.navigate(Screen.Movies.route) {
                            popUpTo("user_selection") { inclusive = true }
                        }
                    },
                    onForgotPasswordClick = {
                        navController.navigate(Screen.ForgotPassword.route)
                    }
                )
            }

            composable("sign_up") {
                SignUpScreen(
                    onSignUpClick = {
                        navController.navigate(Screen.Movies.route) {
                            popUpTo("user_selection") { inclusive = true }
                        }
                    }
                )
            }

            composable("categories") {
                CategoriesScreen(
                    onBackClick = {
                        navController.popBackStack()
                    },
                    onMovieClick = { movieId ->
                        navController.navigate(
                            Screen.MovieDetail.route.replace("{movieId}", movieId)
                        )
                    }
                )
            }



            composable(Screen.Movies.route) {
                MoviesScreen(
                    onMovieClick = { movieId ->
                        navController.navigate(
                            Screen.MovieDetail.route.replace("{movieId}", movieId)
                        )
                    },
                    onCategorySelect = {}
                )
            }

            composable(Screen.Downloads.route) {
                DownloadsScreen(
                    onMovieClick = { movieId ->
                        navController.navigate(
                            Screen.MovieDetail.route.replace("{movieId}", movieId)
                        )
                    }
                )
            }

            composable(Screen.MovieDetail.route) { backStackEntry ->
                val movieId = backStackEntry.arguments?.getString("movieId") ?: ""
                MovieDetailScreen(
                    movieId = movieId,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }

            composable(Screen.Episodes.route) { backStackEntry ->
                val seriesId = backStackEntry.arguments?.getString("seriesId") ?: ""
                EpisodesScreen(
                    seriesId = seriesId,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }

            composable(Screen.MoreMovies.route) {
                MoreMoviesScreen(
                    onMovieClick = { movieId ->
                        navController.navigate(
                            Screen.MovieDetail.route.replace("{movieId}", movieId)
                        )
                    },
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }

            composable(Screen.ForgotPassword.route) {
                ForgotPasswordScreen(
                    onCreatePasswordClick = {
                        navController.navigate(Screen.Movies.route) {
                            popUpTo(Screen.Movies.route) { inclusive = true }
                        }
                    }
                )
            }

            composable(Screen.Watchlist.route) {
                MoreMoviesScreen(
                    onMovieClick = { movieId ->
                        navController.navigate(
                            Screen.MovieDetail.route.replace("{movieId}", movieId)
                        )
                    },
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieAppPreview() {
    MovieAppTheme {
        MovieApp()
    }
}