package com.example.crudretrofitapi.userAuthentication.retrofit

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://crudcrud.com/api/390786dcb0784d4ba5440171382fa330/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }

    val apiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }

}