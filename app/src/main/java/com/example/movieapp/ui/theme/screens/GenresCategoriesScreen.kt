package com.example.movieapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.R

@Composable
fun CategoriesScreen(
    onBackClick: () -> Unit = {},
    onSearchTextChange: (String) -> Unit = {},
    onClearSearch: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onMovieClick: (String) -> Unit = {},
    onBottomNavClick: (String) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(10.dp)
    ) {
        // Top Bar with Search
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
            TextField(
                value = "Input text",
                onValueChange = onSearchTextChange,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.DarkGray,
                    textColor = Color.White
                ),
                modifier = Modifier.weight(5f)
            )
            IconButton(onClick = onClearSearch) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_clear),
                    contentDescription = "Clear",
                    tint = Color.White
                )
            }
            IconButton(onClick = onProfileClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "Profile",
                    tint = Color.White,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Genres List
        val genres = listOf("Genre 1", "Genre 2", "Genre 3")
        genres.forEach { genre ->
            Text(text = genre, color = Color.White, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(3) {
                    Box(
                        modifier = Modifier
                            .size(115.dp, 180.dp)
                            .background(Color.Gray, RoundedCornerShape(8.dp))
                            .clickable { onMovieClick("Movie $it") },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Movie ${it + 1}", color = Color.Black, fontSize = 14.sp)
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.weight(1f))

        // Bottom Navigation
        BottomNavigation(
            backgroundColor = Color.DarkGray,
            modifier = Modifier.fillMaxWidth()
        ) {
            val items = listOf("Home", "Watchlist", "Movies", "Downloads")
            val icons = listOf(
                R.drawable.ic_home, R.drawable.ic_watchlist, R.drawable.ic_movies, R.drawable.ic_download
            )
            items.forEachIndexed { index, item ->
                BottomNavigationItem(
                    selected = false,
                    onClick = { onBottomNavClick(item) },
                    icon = {
                        Icon(
                            painter = painterResource(id = icons[index]),
                            contentDescription = item,
                            tint = Color.White
                        )
                    },
                    label = { Text(text = item, color = Color.White) }
                )
            }
        }
    }
}

// Preview
@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun CategoriesScreenPreview() {
    CategoriesScreen()
}
