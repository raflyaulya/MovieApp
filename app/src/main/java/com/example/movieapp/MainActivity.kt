package com.example.movieapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.*
import com.example.movieapp.ui.*
import com.example.movieapp.ui.screens.HomeScreen
import com.example.movieapp.ui.screens.SignUpScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApp()
        }
    }
}

@Composable
fun MovieApp() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen() }
        composable("signup") { SignUpScreen() }
//        composable("downloads") { DownloadsScreen(navController) }
//        composable("profile") { ProfileScreen(navController) }
    }
}

//@Preview(showBackground = true)
@Preview(widthDp = 392, heightDp = 850, showBackground = true,
    showSystemUi = true)
@Composable
fun PreviewMovieApp() {
    MovieApp()
}