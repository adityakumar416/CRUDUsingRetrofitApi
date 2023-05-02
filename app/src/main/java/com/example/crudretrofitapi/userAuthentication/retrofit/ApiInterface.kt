package com.example.crudretrofitapi.userAuthentication.retrofit

import android.service.autofill.UserData
import com.example.crudretrofitapi.contactHome.addContact.model.ContactData
import com.example.crudretrofitapi.contactHome.addContact.model.ContactDataItem
import com.example.crudretrofitapi.contactHome.displayContact.model.AllContactResponse
import com.example.crudretrofitapi.userAuthentication.model.getAllUser.GetAllUserResponse
import com.example.crudretrofitapi.userAuthentication.model.signup.UserRequest
import com.example.crudretrofitapi.userAuthentication.model.signup.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {

    @POST("signup")
    fun registerUser(@Body userModel: UserRequest) : Call<UserResponse>

    @POST("add")
    fun addContact(@Body contactDataItem: ContactDataItem) : Call<ContactData>

    @GET("signup")
    fun getAllUser(): Call<GetAllUserResponse>

    @GET("{id}")
    fun getAllContact(@Path("id") id : String) : Call<AllContactResponse>

}