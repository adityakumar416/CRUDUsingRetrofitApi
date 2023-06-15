package com.example.crudretrofitapi.userAuthentication.repository

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.crudretrofitapi.contactHome.displayContact.model.AllContactResponse
import com.example.crudretrofitapi.userAuthentication.model.getAllUser.GetAllUserResponse
import com.example.crudretrofitapi.userAuthentication.model.getAllUser.ParticularUserResponseItem
import com.example.crudretrofitapi.userAuthentication.model.signup.UserRequest
import com.example.crudretrofitapi.userAuthentication.model.signup.UserResponse
import com.example.crudretrofitapi.userAuthentication.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object UserRepository {
    val userResponse=MutableLiveData<UserResponse>()
    val isEmailExist = MutableLiveData<Boolean>()
    val getAllUserResponse = MutableLiveData<GetAllUserResponse>()

    val getSingleUserResponse = MutableLiveData<ParticularUserResponseItem>()



    @SuppressLint("SuspiciousIndentation")
    suspend fun registerUser(userRequest: UserRequest):MutableLiveData<UserResponse>{

        val call = RetrofitInstance.apiInterface.registerUser(userRequest)

        call.enqueue(object : Callback<UserResponse?> {
            override fun onResponse(call: Call<UserResponse?>, response: Response<UserResponse?>) {

                Log.d("DEBUG resp :",response.body().toString())

                userResponse.value = response.body()
            }

            override fun onFailure(call: Call<UserResponse?>, t: Throwable) {
                Log.d("DEBUG error :",t.message.toString())
            }
        })
        return userResponse
    }

    suspend fun loginUser(email: String, password:String):MutableLiveData<ParticularUserResponseItem>?{

        val call = RetrofitInstance.apiInterface.getAllUser()

        call.enqueue(object : Callback<GetAllUserResponse?> {
            override fun onResponse(
                call: Call<GetAllUserResponse?>,
                response: Response<GetAllUserResponse?>
            ) {
                Log.i("error", response.toString())

                getAllUserResponse.value = response.body()

                getSingleUserResponse.value = getAllUserResponse.value?.let {
                    verifyUser(it,email,password) ?: ParticularUserResponseItem()
                }


            }

            override fun onFailure(call: Call<GetAllUserResponse?>, t: Throwable) {
                Log.i("error", t.message.toString())

            }
        })
        return getSingleUserResponse
    }

    private fun verifyUser(user: GetAllUserResponse, email: String, password: String): ParticularUserResponseItem? {

        return user.find { it.email == email && it.password == password }

    }


     suspend fun checkUserExist(email: String):MutableLiveData<Boolean>{

        val call = RetrofitInstance.apiInterface.getAllUser()

        call.enqueue(object : Callback<GetAllUserResponse?> {
            override fun onResponse(
                call: Call<GetAllUserResponse?>,
                response: Response<GetAllUserResponse?>
            ) {
                Log.i("error", response.toString())

                getAllUserResponse.value = response.body()
                isEmailExist.value = isUserEmailExists(getAllUserResponse.value!!,email)

            }

            override fun onFailure(call: Call<GetAllUserResponse?>, t: Throwable) {
                Log.i("error", t.message.toString())

            }
        })
        return isEmailExist
    }

    private fun isUserEmailExists(user: GetAllUserResponse, email: String): Boolean {

        return user.any {
            user-> user.email == email
        }

    }




}