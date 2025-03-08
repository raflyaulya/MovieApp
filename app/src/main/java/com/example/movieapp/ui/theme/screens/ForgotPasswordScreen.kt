package com.example.movieapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// ===========    FORGOT PASSWORD SCREEN   ===================
@Composable
// BAGIAN FORGOT PASSWORD ADA SMTHG WRONG dgn design nya, PERLU PERBAIKAN !!!  =============
fun ForgotPasswordScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Lupa Kata Sandi", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* Logika lupa kata sandi */ }, modifier = Modifier.fillMaxWidth()) {
            Text("Kirim Tautan Reset")
        }
    }
}

//@Preview(showBackground = true)
@Preview(widthDp = 392, heightDp = 850, showBackground = true,
    showSystemUi = true)
@Composable
fun ForgotPasswordScreenPreview() {
    ForgotPasswordScreen()
}