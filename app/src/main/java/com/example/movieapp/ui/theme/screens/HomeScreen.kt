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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen() {
    val dummyMovies = listOf(
        android.R.drawable.ic_menu_gallery,
        android.R.drawable.ic_menu_gallery,
        android.R.drawable.ic_menu_gallery
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        // Banner Utama (Gunakan Placeholder jika Tidak Ada Gambar)
        Image(
            painter = painterResource(id = android.R.drawable.ic_menu_gallery),
            contentDescription = "Banner",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

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
                Text(
                    text = category,
                    color = Color.White,
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .background(Color.Gray)
                        .padding(8.dp)
                )
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
        LazyRow {
            items(dummyMovies) { movie ->
                Image(
                    painter = painterResource(id = movie),
                    contentDescription = "Movie Poster",
                    modifier = Modifier
                        .size(120.dp, 180.dp)
                        .padding(end = 8.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
