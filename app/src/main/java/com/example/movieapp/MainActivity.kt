package com.example.movieapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AccountSelectionScreen(onCreateAccountClick: () -> Unit = {}, onAccountClick: (String) -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxSize(), //.background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Which one is your account?", fontSize = 20.sp, color = Color.White)
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            AccountButton("User 1") { onAccountClick("User 1") }
            AccountButton("User 2") { onAccountClick("User 2") }
        }
        Row {
            AccountButton("User 3") { onAccountClick("User 3") }
            AccountButton("User 4") { onAccountClick("User 4") }
        }
        Spacer(modifier = Modifier.height(20.dp))
        ClickableText(text = AnnotatedString("Create account?"), onClick = { onCreateAccountClick() })
    }
}

@Composable
fun AccountButton(name: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        modifier = Modifier
            .size(100.dp)
            .padding(10.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = android.R.drawable.ic_menu_gallery), contentDescription = null)
            Text(text = name, fontSize = 14.sp)
        }
    }
}

@Composable
fun SignUpScreen(onSignUp: () -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello, There!\nPlease create your Account", fontSize = 20.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = "", onValueChange = {}, label = { Text("Email") })
        TextField(value = "", onValueChange = {}, label = { Text("Password") })
        TextField(value = "", onValueChange = {}, label = { Text("Confirm Password") })
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = onSignUp) { Text("Sign Up") }
    }
}

@Composable
fun SignInScreen(userName: String = "User", onSignIn: () -> Unit = {}, onForgotPassword: () -> Unit = {}) {
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
        ClickableText(text = AnnotatedString("Forgot password?"), onClick = { onForgotPassword() })
    }
}

//@Preview(showBackground = true)
@Preview(widthDp = 392, heightDp = 850, showBackground = true,
    showSystemUi = true)
@Composable
fun PreviewAccountSelectionScreen() {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.Gray)
            .padding(top = 50.dp, bottom = 50.dp)
    ){
        AccountSelectionScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignUpScreen() {
    SignUpScreen()
}

@Preview(showBackground = true)
@Composable
fun PreviewSignInScreen() {
    SignInScreen()
}

