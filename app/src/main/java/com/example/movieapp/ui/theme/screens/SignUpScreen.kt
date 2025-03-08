package com.example.movieapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SignUpScreen(onSignUp: () -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello, There!\nPlease create your Account",
            fontSize = 20.sp,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = "", onValueChange = {}, label = { Text("Email") })
        TextField(value = "", onValueChange = {}, label = { Text("Password") })
        TextField(value = "", onValueChange = {}, label = { Text("Confirm Password") })
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = onSignUp) { Text("Sign Up") }
    }
}

@Preview(widthDp = 392, heightDp = 850, showBackground = true,
    showSystemUi = true)
@Composable
fun PreviewSignUpScreen() {
    SignUpScreen()
}



//
//@Composable
//fun MovieListScreen(navController: NavController) {
//    LazyColumn {
//        items(movies) { movie ->
//            MovieItem(movie = movie, onClick = {
//                navController.navigate("movieDetail/${movie.id}")
//            })
//        }
//    }
//}
//
//@Composable
//fun MovieItem(movie: Movie, onClick: () -> Unit) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//    ) {
//        Column(
//            modifier = Modifier.padding(16.dp)
//        ) {
//            Text(text = movie.title)
//            Text(text = movie.description)
//            Text(text = "Rating: ${movie.rating}")
//        }
//    }
//}