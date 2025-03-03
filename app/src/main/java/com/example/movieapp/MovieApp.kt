package com.example.movieapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun MovieApp(content: @Composable () -> Unit) {
    MaterialTheme {
        content()
    }
}