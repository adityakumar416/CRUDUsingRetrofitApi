package com.example.crudretrofitapi.contactHome.displayContact.repository

import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.crudretrofitapi.contactHome.addContact.model.AddContactRequest
import com.example.crudretrofitapi.contactHome.addContact.model.AddContactResponse

import com.example.crudretrofitapi.contactHome.displayContact.model.AllContactResponse
import com.example.crudretrofitapi.contactHome.displayContact.model.AllContactResponseItem
import com.example.crudretrofitapi.contactHome.update.model.UpdateModel
import com.example.crudretrofitapi.sharedPreference.Constant
import com.example.crudretrofitapi.sharedPreference.PrefManager
import com.example.crudretrofitapi.userAuthentication.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ContactRepository {

    var getAllContactResponse = MutableLiveData<AllContactResponse>()
    var contactResponse = MutableLiveData<AddContactResponse>()
    var updateContact = MutableLiveData<AddContactResponse>()
    var deleteContact = MutableLiveData<Boolean>()

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
                Log.i("error", t.message.toString())
            }
        })
        return getAllContactResponse
    }


    fun addUser(id: String,contactDataItem: AddContactRequest):MutableLiveData<AddContactResponse>{
        val call = RetrofitInstance.apiInterface.addContact(id,contactDataItem)

        call.enqueue(object : Callback<AddContactResponse?> {
            override fun onResponse(
                call: Call<AddContactResponse?>,
                response: Response<AddContactResponse?>
            ) {
                contactResponse.value = response.body()
            }

            override fun onFailure(call: Call<AddContactResponse?>, t: Throwable) {
                Log.i("error", t.message.toString())
            }
        })


            return contactResponse
    }


    fun updateUser(id: String,contactDataItem: AllContactResponseItem){
         RetrofitInstance.apiInterface.updateContact(id,contactDataItem)

    }

    fun deleteContact(id:String,idOfContact: String):MutableLiveData<Boolean>{
        val call = RetrofitInstance.apiInterface.deleteContact(id,idOfContact)

        call.enqueue(object : Callback<Any?> {
            override fun onResponse(
                call: Call<Any?>,
                response: Response<Any?>
            ) {

                if(response.code()==200){
                    deleteContact.value = true
                }
                else{
                    deleteContact.value = false

                }
            }

            override fun onFailure(call: Call<Any?>, t: Throwable) {
                Log.i("error", t.message.toString())
            }


        })


        return deleteContact
    }


}