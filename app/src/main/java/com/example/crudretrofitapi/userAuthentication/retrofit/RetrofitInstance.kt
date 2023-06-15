package com.example.crudretrofitapi.userAuthentication.retrofit

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit:Retrofit.Builder by lazy {
        Retrofit.Builder().baseUrl("https://crudcrud.com/api/6688663c989143429af64bd11540fd60/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())

    }

    val apiInterface:ApiInterface by lazy {
        retrofit
        .build()
        .create(ApiInterface::class.java)
    }

}