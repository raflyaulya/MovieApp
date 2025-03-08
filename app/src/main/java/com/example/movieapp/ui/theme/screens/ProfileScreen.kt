package com.example.movieapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.movieapp.R


@Composable
fun ProfileScreen(
    onBackClick: () -> Unit = {},
    onModifyProfilesClick: () -> Unit = {},
    onMenuClick: (String) -> Unit = {},
    onSignOutClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(26.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Back Button & Title
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
            Text(
                text = "Profile accounts & More",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Profile Icons
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            listOf("User 1", "User 2", "User 3", "User 4").forEach { user ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = rememberImagePainter(data = R.drawable.profile_placeholder),
                        contentDescription = "Profile Image",
                        modifier = Modifier
                            .size(60.dp)
                            .background(Color.Gray, CircleShape)
                    )
                    Text(text = user, color = Color.White, fontSize = 14.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Modify Profile
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { onModifyProfilesClick() }
                .padding(vertical = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_edit),
                contentDescription = "Edit",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = "Modify Profiles",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Menu List (dengan ikon yang benar)
        val menuItems = listOf(
            "My List" to R.drawable.ic_list,
            "Settings" to R.drawable.ic_settings,  // PERBAIKI ICON SETTING INI NANTI !!!
            "Account" to R.drawable.ic_account,
            "Help" to R.drawable.ic_help
        )

        menuItems.forEach { (item, icon) ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray, RoundedCornerShape(8.dp))
                    .clickable { onMenuClick(item) }
                    .padding(16.dp)
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = item,
                    tint = Color.White
                )
                Text(
                    text = item,
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Home Button
        Button(
            onClick = { onMenuClick("Home") },
            colors = ButtonDefaults.buttonColors(Color.DarkGray),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 80.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_home),
                contentDescription = "Home",
                tint = Color.White
            )
            Text(text = " Home", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sign Out
        Text(
            text = "Sign Out ?",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable { onSignOutClick() }
                .padding(8.dp)
        )
    }
}

// ============================ @PREVIEW ===================================
@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}

