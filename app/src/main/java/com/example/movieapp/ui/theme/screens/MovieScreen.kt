package com.example.movieapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movieapp.viewmodel.MovieViewModel

@Composable
fun MovieScreen(
    viewModel: MovieViewModel = viewModel(),
    onMovieClick: (String) -> Unit
) {
    // Mengambil state dari ViewModel
    val movies by viewModel.movies.collectAsState()
    val error by viewModel.error.collectAsState()

    // Memuat data saat pertama kali screen dibuka
    LaunchedEffect(Unit) {
        viewModel.fetchPopularMovies("fbb9572d11b5458ac98f02b84f2bafc4") // Ganti dengan API key Anda
    }

    // Menampilkan UI berdasarkan state
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        if (movies.isNotEmpty()) {
            LazyColumn {
                items(movies) { movie ->
                    MovieCard(
                        movie = movie,
                        onClick = { onMovieClick(movie.id.toString()) }
                    )
                }
            }
        } else if (error != null) {
            Text(text = "Error: $error", color = Color.Red)
        } else {
            CircularProgressIndicator() // Menampilkan loading indicator
        }
    }
}