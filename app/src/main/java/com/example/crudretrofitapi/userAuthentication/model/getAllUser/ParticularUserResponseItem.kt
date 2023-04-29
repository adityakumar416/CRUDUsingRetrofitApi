package com.example.crudretrofitapi.userAuthentication.model.getAllUser

data class ParticularUserResponseItem(
    val _id: String = "",
    val confirmPassword: String = "",
    val email: String = "User Not Found",
    val name: String = "",
    val password: String =""
)