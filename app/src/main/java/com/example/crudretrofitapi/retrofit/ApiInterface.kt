package com.example.crudretrofitapi.retrofit

import com.example.crudretrofitapi.model.UserRequest
import com.example.crudretrofitapi.model.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("signup")
    fun registerUser(@Body userModel: UserRequest) : Call<UserResponse>


    @POST("signin")
    fun loginUser(@Body userModel: UserRequest) : Call<UserResponse>

}