package com.example.crudretrofitapi.contactHome.addContact.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crudretrofitapi.contactHome.addContact.model.ContactData
import com.example.crudretrofitapi.contactHome.addContact.model.ContactDataItem
import com.example.crudretrofitapi.contactHome.displayContact.repository.ContactRepository
import com.example.crudretrofitapi.userAuthentication.repository.UserRepository

class ContactViewModel:ViewModel() {
    private var addViewModel:MutableLiveData<ContactData>?=null

    fun addContact(contactDataItem: ContactDataItem): LiveData<ContactData>?{
        addViewModel = UserRepository.addUser(contactDataItem)
        return addViewModel
    }


}