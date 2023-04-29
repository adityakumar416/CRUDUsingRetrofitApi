package com.example.crudretrofitapi.contactHome.displayContact.repository

import androidx.lifecycle.MutableLiveData
import com.example.crudretrofitapi.contactHome.displayContact.model.AllContactResponse
import com.example.crudretrofitapi.userAuthentication.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ContactRepository {

    var getAllContactResponse = MutableLiveData<AllContactResponse>()

    fun getAllContact(id:String):MutableLiveData<AllContactResponse>{

        val call = RetrofitInstance.apiInterface.getAllContact(id)

        call.enqueue(object : Callback<AllContactResponse?> {
            override fun onResponse(
                call: Call<AllContactResponse?>,
                response: Response<AllContactResponse?>
            ) {
                getAllContactResponse.value = response.body()
            }

            override fun onFailure(call: Call<AllContactResponse?>, t: Throwable) {

            }
        })
        return getAllContactResponse
    }
}