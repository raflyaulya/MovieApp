package com.example.movieapp.ui.theme.components

//import com.example.movieapp.models.Watchlist
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.Screen
import com.example.movieapp.ui.theme.MovieAppTheme

// components/BottomNavigation.kt
@Composable
fun MovieAppBottomNavigation(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    NavigationBar(
        containerColor = Color.Black,
        contentColor = Color.White
    ) {
        NavigationBarItem(
            selected = currentRoute == Screen.Movies.route,
            onClick = { onNavigate(Screen.Movies.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
            label = { Text("Home") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.Gray,
                indicatorColor = Color.Transparent
            )
        )

        NavigationBarItem(
            selected = currentRoute == Screen.Watchlist.route,
            onClick = { onNavigate(Screen.Watchlist.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Watchlist"
                )
            },
            label = { Text("Watchlist") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.Gray,
                indicatorColor = Color.Transparent
            )
        )

        NavigationBarItem(
            selected = currentRoute == "movies_grid",
            onClick = { onNavigate("movies_grid") },
            icon = {
                Icon(
                    imageVector = Icons.Default.Apps,
                    contentDescription = "Movies"
                )
            },
            label = { Text("Movies") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.Gray,
                indicatorColor = Color.Transparent
            )
        )

        NavigationBarItem(
            selected = currentRoute == Screen.Downloads.route,
            onClick = { onNavigate(Screen.Downloads.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Download,
                    contentDescription = "Downloads"
                )
            },
            label = { Text("Downloads") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.Gray,
                indicatorColor = Color.Transparent
            )
        )
    }
}

@Preview
@Composable
fun MovieAppBottomNavigationPreview() {
    MovieAppTheme {
        MovieAppBottomNavigation(
            currentRoute = Screen.Movies.route,
            onNavigate = {}
        )
    }
}