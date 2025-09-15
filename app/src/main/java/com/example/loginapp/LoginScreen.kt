package com.example.loginapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginapp.ui.theme.LoginAppTheme

@Composable
fun LoginScreen(
    viewModel: AuthViewModel = viewModel(),
    onRegisterClick: () -> Unit,
    onLoginSuccess: () -> Unit
) {
    val message by viewModel.message
    val Black = MaterialTheme.colorScheme.primary
    val White = MaterialTheme.colorScheme.secondary

    Surface (color = Black){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text("Login", style = MaterialTheme.typography.headlineLarge,
                color = White)

            Spacer(Modifier.height(20.dp))

            OutlinedTextField(
                value = viewModel.email.value,
                onValueChange = { viewModel.email.value = it },
                label = { Text("Email", color = White) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = White,
                    unfocusedTextColor = White,
                    focusedContainerColor = Black,
                    unfocusedContainerColor = Black,
                    focusedIndicatorColor = White,
                    unfocusedIndicatorColor = White
                )
            )

            OutlinedTextField(
                value = viewModel.password.value,
                onValueChange = { viewModel.password.value = it },
                label = { Text("Password", color = White) },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = White,
                    unfocusedTextColor = White,
                    focusedContainerColor = Black,
                    unfocusedContainerColor = Black,
                    focusedIndicatorColor = White,
                    unfocusedIndicatorColor = White
                )
            )

            Spacer(Modifier.height(20.dp))

            Button(
                onClick = { viewModel.login(onLoginSuccess) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = White,
                    contentColor = Black
                )
            ) {
                Text("Login")
            }

            TextButton(onClick = { onRegisterClick() }) {
                Text("Belum punya akun? Register", color = White)
            }

            Spacer(Modifier.height(10.dp))
            Text(message, color = White)
        }
    }

}


//@Preview(showBackground = true)
//@Composable
//fun PreviewLogin() {
//    MaterialTheme {
//        LoginScreen(onRegisterClick = {}, onLoginSuccess = {})
//    }
//}

@Preview(showBackground = true)
@Composable
fun PreviewLoginDark() {
    MaterialTheme {
        LoginAppTheme (darkTheme = true, dynamicColor = false){
        LoginScreen(onRegisterClick = {}, onLoginSuccess = {})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginLight() {
    MaterialTheme {
        LoginAppTheme (darkTheme = false, dynamicColor = false){
            LoginScreen(onRegisterClick = {}, onLoginSuccess = {})
        }
    }
}