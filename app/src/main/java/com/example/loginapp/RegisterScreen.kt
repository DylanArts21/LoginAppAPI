package com.example.loginapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginapp.ui.theme.LoginAppTheme

@Composable
fun RegisterScreen(
    viewModel: AuthViewModel = viewModel(),
    onBackToLogin: () -> Unit,
    modifier: Modifier = Modifier
) {
    val message by viewModel.message
    val Black = MaterialTheme.colorScheme.primary
    val White = MaterialTheme.colorScheme.secondary

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text("Register", style = MaterialTheme.typography.headlineLarge,
                color = White)

            Spacer(Modifier.height(20.dp))

            OutlinedTextField(
                value = viewModel.email.value,
                onValueChange = { viewModel.email.value = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = White,
                    unfocusedTextColor = White,
                    focusedContainerColor = Black,
                    unfocusedContainerColor = Black,
                )
            )

            OutlinedTextField(
                value = viewModel.password.value,
                onValueChange = { viewModel.password.value = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = White,
                    unfocusedTextColor = White,
                    focusedContainerColor = Black,
                    unfocusedContainerColor = Black,
                )
            )

            Spacer(Modifier.height(20.dp))

            Button(
                onClick = { viewModel.register(onBackToLogin) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = White,
                    contentColor = Black
                )
            ) {
                Text("Register")
            }

            TextButton(onClick = { onBackToLogin() }) {
                Text("Sudah punya akun? Login", color = White)
            }

            Spacer(Modifier.height(10.dp))
            Text(message, color = White)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewRegister() {
//    MaterialTheme {
//        RegisterScreen(onBackToLogin = {})
//    }
//}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterDark() {
    MaterialTheme {
        LoginAppTheme(darkTheme = true, dynamicColor = false) {
            RegisterScreen(onBackToLogin = {})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterLight() {
    MaterialTheme {
        LoginAppTheme(darkTheme = false, dynamicColor = false) {
            RegisterScreen(onBackToLogin = {})
        }
    }
}