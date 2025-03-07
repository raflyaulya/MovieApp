package com.example.movieapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieapp.data.movies
import com.example.movieapp.model.Movie

@Composable
fun MovieDetailScreen(movieId: Int) {
    val movie = movies.find { it.id == movieId } ?: return
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = movie.title)
        Spacer(modifier = Modifier.height(118.dp))
        Text(text = movie.description)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Rating: ${movie.rating}")
    }
}

