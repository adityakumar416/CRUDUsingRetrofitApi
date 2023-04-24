package com.example.crudretrofitapi.repository

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.crudretrofitapi.model.UserRequest
import com.example.crudretrofitapi.model.UserResponse
import com.example.crudretrofitapi.retrofit.ApiInterface
import com.example.crudretrofitapi.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object UserRepository {
    val userResponse=MutableLiveData<UserResponse>()

    //val viewAllData : LiveData<List<UserRequest>>()

//    fun registerUser(userRequest: UserRequest) {
//        val response = ApiInterface.registerUser(userRequest)
//        handleResponse(response)
//    }

    fun registerUser(userRequest: UserRequest):MutableLiveData<UserResponse>{

        val call = RetrofitInstance.apiInterface.registerUser(userRequest)

            call.enqueue(object : Callback<UserResponse?> {
                override fun onResponse(
                    call: Call<UserResponse?>,
                    response: Response<UserResponse?>
                ) {
                    Log.i("error", response.toString())

                    userResponse.value = response.body()


                }

                override fun onFailure(call: Call<UserResponse?>, t: Throwable) {
                    Log.i("error", t.message.toString())

                }
            })
        return userResponse
    }


    fun loginUser(userRequest: UserRequest):MutableLiveData<UserResponse>{

        val call = RetrofitInstance.apiInterface.loginUser(userRequest)

        call.enqueue(object : Callback<UserResponse?> {
            override fun onResponse(
                call: Call<UserResponse?>,
                response: Response<UserResponse?>
            ) {
                Log.i("error", response.toString())

                userResponse.value = response.body()


            }

            override fun onFailure(call: Call<UserResponse?>, t: Throwable) {
                Log.i("error", t.message.toString())

            }
        })
        return userResponse
    }



}