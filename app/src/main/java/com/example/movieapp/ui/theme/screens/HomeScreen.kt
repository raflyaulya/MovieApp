package com.example.movieapp.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.movieapp.viewmodel.MovieViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movieapp.ui.screens.MovieCard

@Composable
fun HomeScreen(viewModel: MovieViewModel = viewModel()) {
    val movies by viewModel.movies.collectAsState()
    val error by viewModel.error.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchPopularMovies("fbb9572d11b5458ac98f02b84f2bafc4")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        // Banner Utama (Placeholder)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.DarkGray)
        ) {
            Text(
                text = "Banner Placeholder",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Kategori
        Text(
            text = "Categories",
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyRow {
            items(listOf("Action", "Comedy", "Drama", "Horror", "Sci-Fi")) { category ->
                Box(
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .background(Color.Gray)
                        .padding(8.dp)
                ) {
                    Text(
                        text = category,
                        color = Color.White
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // List Film Trending
        Text(
            text = "Watch it Now!",
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        if (error != null) {
            Text(text = "Error: $error", color = Color.Red)
        } else {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(movies) { movie ->
                    MovieCard(
                        movie = movie,
                        onClick = {
                            // Handle click event here
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}