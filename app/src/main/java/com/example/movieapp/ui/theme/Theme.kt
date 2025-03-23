package com.example.movieapp.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Theme.kt
//import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    // ... warna-warna lain ...
    surface = Color(0xFFF5F5F5), // Warna untuk container di mode terang
    surfaceVariant = Color(0xFFEEEEEE), // Warna alternatif untuk container di mode terang
    background = Color(0xFFFFFFFF) // Warna untuk background di mode terang
)

val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    // ... warna-warna lain ...
    surface = Color(0xFF303030), // Warna untuk container di mode gelap
    surfaceVariant = Color(0xFF424242), // Warna alternatif untuk container di mode gelap
    background = Color(0xFF121212) // Warna untuk background di mode gelap
)

@Composable
fun MovieAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}


