package com.example.crudretrofitapi.model

data class UserRequest(
    val name: String,
    val email: String,
    val password: String,
    val confirmPassword: String
)