package com.example.crudretrofitapi.contactHome.addContact.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.crudretrofitapi.contactHome.addContact.model.ContactData
import com.example.crudretrofitapi.contactHome.addContact.model.ContactDataItem
import com.example.crudretrofitapi.userAuthentication.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

object ContactRepository {
    val contactModel = MutableLiveData<ContactData>()

    fun addUser(contactDataItem: ContactDataItem):MutableLiveData<ContactData>{
        val call = RetrofitInstance.apiInterface.addContact(contactDataItem)
        call.enqueue(object : Callback<ContactData?> {
            override fun onResponse(call: Call<ContactData?>, response: Response<ContactData?>) {
                Log.i("error", response.toString())
                contactModel.value = response.body()
            }

            override fun onFailure(call: Call<ContactData?>, t: Throwable) {
                Log.i("error", t.message.toString())

            }
        })
        return contactModel

    }


}