package com.example.movieapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SignInScreen(userName: String = "User X", onSignIn: () -> Unit = {}, onForgotPassword: () -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello, $userName\nWelcome back!", fontSize = 20.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = "", onValueChange = {}, label = { Text("Email") })
        TextField(value = "", onValueChange = {}, label = { Text("Password") })
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = onSignIn) { Text("Sign In") }
        Spacer(modifier = Modifier.height(10.dp))
        ClickableText(text = AnnotatedString("\n\nForgot password?"), onClick = { onForgotPassword() })
    }
}

//@Preview(showBackground = true)
@Preview(widthDp = 392, heightDp = 850, showBackground = true,
    showSystemUi = true)
@Composable
fun PreviewSignInScreen() {
    SignInScreen()
}