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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ContactRepository {

    var getAllContactResponse = MutableLiveData<AllContactResponse>()
    var contactResponse = MutableLiveData<AddContactResponse>()
    var updateContact = MutableLiveData<Boolean>()
    var deleteContact = MutableLiveData<Boolean>()
    val isNumberExist = MutableLiveData<Boolean>()

     suspend fun getAllContact(id:String):MutableLiveData<AllContactResponse> {

         return withContext(Dispatchers.IO) {
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
             getAllContactResponse
         }
     }


    suspend fun addUser(id: String,contactDataItem: AddContactRequest):MutableLiveData<AddContactResponse>{
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


    suspend fun updateUser(id:String,idOfContact: String,updateModel: UpdateModel):MutableLiveData<Boolean>{
        val call = RetrofitInstance.apiInterface.updateContact(id,idOfContact,updateModel)

        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void?>) {

                Log.d("DEBUG upt cntct resp :",response.body().toString())

                if(response.code()==200)
                {
                    updateContact.value= true
                } else {
                    updateContact.value= false
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.d("DEBUG error :",t.message.toString())
            }
        })
        return updateContact
    }


    suspend fun deleteContact(id:String,idOfContact: String):MutableLiveData<Boolean>{
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

  /*  suspend fun isNumberExist(id:String,number:String):MutableLiveData<Boolean>{
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
        return isNumberExist
    }*/


}