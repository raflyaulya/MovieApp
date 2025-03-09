package com.example.movieapp

import androidx.compose.runtime.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.*
import com.example.movieapp.ui.screens.AccountSelectionScreen
import com.example.movieapp.ui.screens.DownloadsScreen
import com.example.movieapp.ui.screens.ForgotPasswordScreen
import com.example.movieapp.ui.screens.HomeScreen
import com.example.movieapp.ui.screens.ProfileScreen
import com.example.movieapp.ui.screens.SignInScreen
import com.example.movieapp.ui.screens.SignUpScreen
//import com.example.movieapp.ui.screens.GenresCategoriesScreen

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

    NavHost(navController, startDestination = "accountSelection") {
        composable("accountSelection") { AccountSelectionScreen() }
        composable("home") { HomeScreen() }
        composable("signUp") { SignUpScreen() }
        composable("signIn") { SignInScreen() }
        composable("forgotPass") { ForgotPasswordScreen() }
        composable("downloads") { DownloadsScreen() }
        composable("profile") { ProfileScreen() }
//        composable("") { GenresCategoriesScreen() }
    }
}

//@Preview(showBackground = true)
@Preview(widthDp = 392, heightDp = 850,
    showBackground = false,
    showSystemUi = true
)
@Composable
fun PreviewMovieApp() {
    MovieApp()
}