package com.example.movieapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

// screens/MoviesScreen.kt


@Composable
fun MyDropdown() {
    var expandedMovies by remember { mutableStateOf(false) }
    var expandedCategories by remember { mutableStateOf(false) }

    Column {
        Text(
            text = "Movies",
            modifier = Modifier.clickable { expandedMovies = true }
        )
        DropdownMenu(
            expanded = expandedMovies,
            onDismissRequest = { expandedMovies = false }
        ) {
            DropdownMenuItem(
                text = { Text("Movie 1") },
                onClick = { /* Handle movie 1 click */ }
            )
            DropdownMenuItem(
                text = { Text("Movie 2") },
                onClick = { /* Handle movie 2 click */ }
            )
            // ... tambahkan item lainnya ...
        }

        Text(
            text = "All Categories",
            modifier = Modifier.clickable { expandedCategories = true }
        )
        DropdownMenu(
            expanded = expandedCategories,
            onDismissRequest = { expandedCategories = false }
        ) {
            DropdownMenuItem(
                text = { Text("Category 1") },
                onClick = { /* Handle category 1 click */ }
            )
            DropdownMenuItem(
                text = { Text("Category 2") },
                onClick = { /* Handle category 2 click */ }
            )
            // ... tambahkan item lainnya ...
        }
    }
}



@Composable
fun MoviesScreen(
    onMovieClick: (String) -> Unit,
    onCategorySelect: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
//                DropdownMenu(
//                    expanded = false,
//                    onDismissRequest = { },
//                    text = "Movies"
//                )
//                DropdownMenu(
//                    expanded = false,
//                    onDismissRequest = { },
//                    text = "All Categories"
//                )
            }

            Row {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.White
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        tint = Color.White
                    )
                }
            }
        }

        // Featured Movie
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .background(Color.DarkGray)
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Movie Sample 2",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { },
                    colors = ButtonDefaults.run {
                        val buttonColors = buttonColors(Color.White)
                        buttonColors
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Play Now",
                        color = Color.Black
                    )
                }
            }
        }

        // Movie Grid
        Text(
            text = "Movies",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(3) { index ->
                MovieCard(
                    title = "Movie ${index + 1}",
                    onClick = { onMovieClick("movie_$index") }
                )
            }
        }
    }
}



@Composable
fun MovieCard(
    title: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(120.dp)
            .height(180.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyDropdownPreview() {
    MyDropdown()
}

@Preview(showBackground = true)
@Composable
fun MovieScreenPreview() {
    MoviesScreen(onMovieClick = {}, onCategorySelect = {})
}

@Preview(showBackground = true)
@Composable
fun MovieCardPreview() {
    MovieCard(title = "Movie 1", onClick = {})
}