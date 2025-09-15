package com.example.loginapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginapp.ui.theme.LoginAppTheme

@Composable
fun HomeScreen(onLogout: () -> Unit = {}, modifier: Modifier = Modifier) {
    val Black = MaterialTheme.colorScheme.primary
    val White = MaterialTheme.colorScheme.secondary
    Surface (color = Black){
        Column(
            modifier= Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Selamat Login Berhasil",
                style = MaterialTheme.typography.headlineMedium,
                color = White)
            Spacer(Modifier.height(20.dp))
            Button(onClick = { onLogout() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = White,
                    contentColor = Black
                )
            ) {
                Text("Logout")
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewHome() {
//    MaterialTheme {
//        HomeScreen()
//    }
//}

@Preview(showBackground = true)
@Composable
fun PreviewHomeDark() {
    MaterialTheme {
        LoginAppTheme(darkTheme = true, dynamicColor = false) {
            HomeScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeLight() {
    MaterialTheme {
        LoginAppTheme(darkTheme = false, dynamicColor = false) {
            HomeScreen()
        }
    }
}
