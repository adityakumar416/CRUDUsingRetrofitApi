package com.example.crudretrofitapi.contactHome.displayContact.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crudretrofitapi.contactHome.displayContact.model.AllContactResponse
import com.example.crudretrofitapi.contactHome.displayContact.repository.ContactRepository

class ContactViewModel : ViewModel() {

 var getAllContact : MutableLiveData<AllContactResponse>?=null

    fun getAllContact(id:String):LiveData<AllContactResponse>?{

       getAllContact = ContactRepository.getAllContact(id)

        return getAllContact
    }


}