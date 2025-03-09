package com.example.movieapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.R
import com.example.movieapp.Screen

// ============================ MORE MOVIES SCREEN ============================
@Composable
fun MoreMoviesScreen(
    onBackClick: () -> Unit = {},
    onSearchClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onMovieClick: Any
) {
    Column(modifier = Modifier.fillMaxSize().background(Color.Black).padding(16.dp)) {
        // Header
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onBackClick) {
                Icon(painter = painterResource(id = R.drawable.ic_arrow_back), contentDescription = "Back", tint = Color.White)
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = onSearchClick) {
                Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "Search", tint = Color.White)
            }
            IconButton(onClick = onProfileClick) {
                Icon(painter = painterResource(id = R.drawable.ic_profile), contentDescription = "Profile", tint = Color.White)
            }
        }

        // Tab Selection
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {}, shape = RoundedCornerShape(8.dp)) {
                Text("MORE MOVIES")
            }
            OutlinedButton(onClick = {}, shape = RoundedCornerShape(8.dp)) {
                Text("WATCHLIST")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Movie Grid
        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
            items(9) {
                Box(modifier = Modifier.padding(8.dp).size(100.dp).background(Color.Gray)) {
                    Text("Movie ${it + 1}", color = Color.Black, modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    }
}

// ============================ WATCHLIST SCREEN ============================
@Composable
fun WatchlistScreen(onBackClick: () -> Unit = {}, onSearchClick: () -> Unit = {}, onProfileClick: () -> Unit = {}) {
    Column(modifier = Modifier.fillMaxSize().background(Color.Black).padding(16.dp)) {
        // Header
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onBackClick) {
                Icon(painter = painterResource(id = R.drawable.ic_arrow_back), contentDescription = "Back", tint = Color.White)
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = onSearchClick) {
                Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "Search", tint = Color.White)
            }
            IconButton(onClick = onProfileClick) {
                Icon(painter = painterResource(id = R.drawable.ic_profile), contentDescription = "Profile", tint = Color.White)
            }
        }

        // Tab Selection
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            OutlinedButton(onClick = {}, shape = RoundedCornerShape(8.dp)) {
                Text("MORE MOVIES")
            }
            Button(onClick = {}, shape = RoundedCornerShape(8.dp)) {
                Text("WATCHLIST")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Movie Grid
        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
            items(5) {
                Box(modifier = Modifier.padding(8.dp).size(100.dp).background(Color.Gray)) {
                    Text("Movie ${it + 1}", color = Color.Black, modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    }
}

// ============================ PREVIEWS ============================
@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun MoreMoviesPreview() {
    MoreMoviesScreen(onMovieClick = { movieId ->
        navController.navigate(
            Screen.MovieDetail.route.replace("{movieId}", movieId)
        )
    })
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun WatchlistPreview() {
    WatchlistScreen()
}


//============================      @PRERVIEW   ==============================================
//@Preview(showBackground = true)
//@Preview(widthDp = 392, heightDp = 850, showBackground = true,
//    showSystemUi = true)
//@Composable
//fun MoreMoviesPreview() {
//    MoreMoviesScreen()
//}
//
//@Preview(widthDp = 392, heightDp = 850, showBackground = true,
//    showSystemUi = true)
//@Composable
//fun WatchlistScreenPreview() {
//    WatchlistScreen()
//}