package com.example.movieapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DownloadsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Judul Halaman
        Text(
            text = "Downloads",
            color = Color.White,
            fontSize = 22.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Daftar Film yang Terunduh
        val downloadedMovies = listOf(
            "Movie 1",
            "Movie 2",
            "Movie 3",
            "Movie 4"
        )

        if (downloadedMovies.isEmpty()) {
            // Jika Tidak Ada Download
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = android.R.drawable.ic_menu_report_image),
                    contentDescription = "No Downloads",
                    modifier = Modifier.size(120.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "No Downloads Yet",
                    color = Color.Gray,
                    fontSize = 18.sp
                )
            }
        } else {
            // List Downloaded Movies
            LazyColumn {
                items(downloadedMovies) { movie ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                            contentDescription = "Movie Poster",
                            modifier = Modifier.size(80.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(text = movie, color = Color.White, fontSize = 18.sp)
                            Text(text = "Downloaded", color = Color.Gray, fontSize = 14.sp)
                        }
                    }
                }
            }
        }
    }
}

// ========================== @Preview ==========================
@Preview(widthDp = 392, heightDp = 850, showBackground = true,
    showSystemUi = true)
@Composable
fun DownloadsScreenPreview() {
    MaterialTheme {
        DownloadsScreen()
    }
}
