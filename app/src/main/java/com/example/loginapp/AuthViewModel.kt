package com.example.loginapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    // state untuk UI
    var email = mutableStateOf("")
    var password = mutableStateOf("")
    var message = mutableStateOf("")
    var token = mutableStateOf<String?>(null)

    // login
    fun login(onSuccess: () -> Unit = {}) {
        viewModelScope.launch {
            try {
                // RetrofitClient.api.login adalah suspend and returns Response<AuthResponse>
                val response = RetrofitClient.api.login(LoginRequest(email.value, password.value))

                if (response.isSuccessful) {
                    val body = response.body()
                    token.value = body?.token

                    if (!token.value.isNullOrEmpty()) {
                        message.value = "Login sukses!"
                        onSuccess()
                    } else {
                        message.value = "Login gagal: token kosong"
                    }
                } else {
                    // tampilkan response code + body error supaya gampang debug
                    message.value = "Error (${response.code()}): ${response.errorBody()?.string()}"
                }
            } catch (e: Exception) {
                message.value = "Exception: ${e.localizedMessage ?: e.message}"
            }
        }
    }

    // register
    fun register(onSuccess: () -> Unit = {}) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.api.register(LoginRequest(email.value, password.value))

                if (response.isSuccessful) {
                    val body = response.body()
                    token.value = body?.token

                    if (!token.value.isNullOrEmpty()) {
                        message.value = "Register sukses!"
                        onSuccess()
                    } else {
                        message.value = "Register gagal: token kosong"
                    }
                } else {
                    message.value = "Error (${response.code()}): ${response.errorBody()?.string()}"
                }
            } catch (e: Exception) {
                message.value = "Exception: ${e.localizedMessage ?: e.message}"
            }
        }
    }
}
