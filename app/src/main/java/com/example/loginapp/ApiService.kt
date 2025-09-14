package com.example.loginapp

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

data class LoginRequest(val email: String, val password: String)
data class AuthResponse(val token: String?, val id: Int? = null, val error: String? = null)

interface ApiService {
    @Headers("x-api-key: reqres-free-v1") // tambahkan API key di setiap request
    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<AuthResponse>

    @Headers("x-api-key: reqres-free-v1")
    @POST("register")
    suspend fun register(@Body request: LoginRequest): Response<AuthResponse>
}
