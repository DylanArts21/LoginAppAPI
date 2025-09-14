package com.example.loginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                var isLoggedIn by remember { mutableStateOf(false) }
                var showRegister by remember { mutableStateOf(false) }

                when {
                    isLoggedIn -> HomeScreen(onLogout = { isLoggedIn = false })
                    showRegister -> RegisterScreen(onBackToLogin = { showRegister = false })
                    else -> LoginScreen(
                        onRegisterClick = { showRegister = true },
                        onLoginSuccess = { isLoggedIn = true }
                    )
                }
            }
        }
    }
}
