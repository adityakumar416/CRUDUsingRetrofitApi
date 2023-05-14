package com.example.crudretrofitapi.userAuthentication.retrofit

import com.example.crudretrofitapi.contactHome.addContact.model.AddContactRequest
import com.example.crudretrofitapi.contactHome.addContact.model.AddContactResponse
import com.example.crudretrofitapi.contactHome.displayContact.model.AllContactResponse
import com.example.crudretrofitapi.contactHome.displayContact.model.AllContactResponseItem
import com.example.crudretrofitapi.contactHome.update.model.UpdateModel
import com.example.crudretrofitapi.userAuthentication.model.getAllUser.GetAllUserResponse
import com.example.crudretrofitapi.userAuthentication.model.signup.UserRequest
import com.example.crudretrofitapi.userAuthentication.model.signup.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiInterface {

    @POST("signup")
    suspend fun registerUser(@Body userModel: UserRequest) : Call<UserResponse>

    @POST("{id}")
    suspend fun addContact(@Path("id") id : String,@Body addContactRequest: AddContactRequest) : Call<AddContactResponse>

    @GET("signup")
    suspend fun getAllUser(): Call<GetAllUserResponse>

    @GET("{id}")
    fun getAllContact(@Path("id") id : String) : Call<AllContactResponse>

    @PUT("{userid}/{contactid}")
    suspend fun updateContact(@Path("userid") userid:String, @Path("contactid") contactid:String,@Body updateModel: UpdateModel) : Call<Void>
    @DELETE("{userid}/{contactid}")
    suspend fun deleteContact(@Path("userid") userid : String,@Path("contactid") contactId:String) : Call<Any>

}