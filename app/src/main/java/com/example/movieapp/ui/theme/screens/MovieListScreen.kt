package com.example.movieapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.data.movies
import com.example.movieapp.model.Movie

@Composable
fun MovieListScreen(navController: NavController) {
    LazyColumn {
        items(movies) { movie ->
            MovieItem(movie = movie, onClick = {
                navController.navigate("movieDetail/${movie.id}")
            })
        }
    }
}

@Composable
fun MovieItem(movie: Movie, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = movie.title)
            Text(text = movie.description)
            Text(text = "Rating: ${movie.rating}")
        }
    }
}