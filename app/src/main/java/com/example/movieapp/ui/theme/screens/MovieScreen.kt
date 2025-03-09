package com.example.movieapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.R

@Composable
fun MovieScreen(
    onBackClick: () -> Unit = {},
    onSearchClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onPlayClick: () -> Unit = {},
    onDownloadClick: () -> Unit = {},
    onMyListClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    onEpisodesClick: () -> Unit = {},
    onBottomNavClick: (String) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackClick) {
                Icon(painterResource(id = R.drawable.ic_arrow_back), "Back", tint = Color.White)
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = onSearchClick) {
                Icon(painterResource(id = R.drawable.ic_search), "Search", tint = Color.White)
            }
            IconButton(onClick = onProfileClick) {
                Icon(painterResource(id = R.drawable.ic_profile), "Profile", tint = Color.White)
            }
        }

        // Movie Thumbnail
        Box(
            modifier = Modifier
                .size(400.dp, 300.dp)
                .background(Color.Gray, RoundedCornerShape(8.dp))
        ) {
            Text(
                text = "Movie",
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }


        // Movie Title and Actions
        Column(modifier = Modifier.padding(16.dp, 20.dp)
                                    .size(400.dp, 100.dp)
        ) {
            Text("Movie 1", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("2022", color = Color.Gray, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Button(
                    onClick = onPlayClick,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                    Icon(painterResource(id = R.drawable.ic_play), "Play", tint = Color.Black)
                    Text(" Play", color = Color.Black)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = onDownloadClick,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(Color.DarkGray)
                ) {
                    Icon(painterResource(id = R.drawable.ic_download), "Download", tint = Color.White)
                    Text(" Download", color = Color.White)
                }
            }
        }

        // Movie Description
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Movie Details
        Text(
            text = "Starring: Actor 1, Actor 2, Actor 3, Actor 4... more",
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = "Creator: Creator 1, Creator 2",
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Bottom Buttons
        Row(
            modifier = Modifier.fillMaxWidth()
                .size(400.dp, 120.dp)
            ,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = onMyListClick) {
                    Icon(painterResource(id = R.drawable.ic_watchlist), "My List", tint = Color.White)
                }
                Text("My List", color = Color.White)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = onShareClick) {
                    Icon(painterResource(id = R.drawable.ic_share), "Share", tint = Color.White)
                }
                Text("Share", color = Color.White)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = onEpisodesClick) {
                    Icon(painterResource(id = R.drawable.ic_episodes), "Episodes", tint = Color.White)
                }
                Text("All Episodes", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Bottom Navigation
        Row(
            modifier = Modifier
                .size(400.dp, 100.dp)
                .fillMaxWidth()
                .background(Color.Black)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically

        ) {
            BottomNavItem("Home", R.drawable.ic_home, onBottomNavClick)
            BottomNavItem("Watchlist", R.drawable.ic_watchlist, onBottomNavClick)
            BottomNavItem("Movies", R.drawable.ic_movies, onBottomNavClick)
            BottomNavItem("Downloads", R.drawable.ic_download, onBottomNavClick)
        }
    }
}

@Composable
fun BottomNavItem(label: String, icon: Int, onClick: (String) -> Unit) {
    Column(
        modifier = Modifier.clickable { onClick(label) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(painterResource(id = icon), contentDescription = label, tint = Color.White)
        Text(text = label, color = Color.White, fontSize = 12.sp)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun MovieScreenPreview() {
    MovieScreen()
}
