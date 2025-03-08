package com.example.movieapp.ui.screens

import android.R
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AccountSelectionScreen(onCreateAccountClick: () -> Unit = {}, onAccountClick: (String) -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent), // Ubah background menjadi transparan
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Which one is your account?", fontSize = 20.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(60.dp))
        Row {
            AccountButton("User 1") { onAccountClick("User 1") }
            AccountButton("User 2") { onAccountClick("User 2") }
        }
        Row {
            AccountButton("User 3") { onAccountClick("User 3") }
            AccountButton("User 4") { onAccountClick("User 4") }
        }
        Spacer(modifier = Modifier.height(50.dp))
        ClickableText(
            text = AnnotatedString("Create account?"),
            onClick = { onCreateAccountClick() },
            style = TextStyle(color = Color.Black)
        )
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
            Image(painter = painterResource(id = R.drawable.ic_menu_gallery), contentDescription = null)
            Text(text = name, fontSize = 14.sp)
        }
    }
}


//=================================     @ PREVIEW    ==================================
//@Preview(widthDp = 392, heightDp = 850, showBackground = false, // Hilangkan showBackground
//    showSystemUi = true)
//@Composable
//fun PreviewAccountSelectionScreen() {
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Gray) // Atur background hitam di sini
//            .padding(top = 50.dp, bottom = 50.dp)
//    ){
//        AccountSelectionScreen()
//    }
//}
@Preview(widthDp = 392, heightDp = 850, showBackground = false, // Hilangkan showBackground
    showSystemUi = true)
@Composable
fun PreviewAccountSelectionScreen() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = false // Set ke false agar ikon berwarna putih

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray) // Atur background hitam di sini
            .padding(top = 50.dp, bottom = 50.dp)
    ){
        AccountSelectionScreen()
    }
}

