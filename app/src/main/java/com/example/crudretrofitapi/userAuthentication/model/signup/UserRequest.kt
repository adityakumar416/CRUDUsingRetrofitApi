package com.example.crudretrofitapi.userAuthentication.model.signup

data class UserRequest(
    val name: String,
    val email: String,
    val password: String,
    val confirmPassword: String
)