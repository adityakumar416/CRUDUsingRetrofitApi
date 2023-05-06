package com.example.crudretrofitapi.contactHome.displayContact.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crudretrofitapi.contactHome.addContact.model.AddContactRequest
import com.example.crudretrofitapi.contactHome.addContact.model.AddContactResponse
import com.example.crudretrofitapi.contactHome.displayContact.model.AllContactResponse
import com.example.crudretrofitapi.contactHome.displayContact.model.AllContactResponseItem
import com.example.crudretrofitapi.contactHome.displayContact.repository.ContactRepository
import com.example.crudretrofitapi.contactHome.update.model.UpdateModel
import com.example.crudretrofitapi.sharedPreference.Constant
import com.example.crudretrofitapi.sharedPreference.PrefManager

class ContactViewModel : ViewModel() {

    private var getAllContact : MutableLiveData<AllContactResponse>?=null

    private var addViewModel:MutableLiveData<AddContactResponse>?=null
    private var contactDelete:MutableLiveData<Boolean>?=null
    private var updateViewModel:MutableLiveData<AddContactResponse>?=null

    fun getAllContact(id:String):LiveData<AllContactResponse>?{

       getAllContact = ContactRepository.getAllContact(id)

        return getAllContact
    }

    fun addContact(id: String,contactDataItem: AddContactRequest): LiveData<AddContactResponse>?{
        addViewModel = ContactRepository.addUser(id,contactDataItem)
        return addViewModel
    }

    fun updateContact(id: String,contactDataItem: UpdateModel){
       ContactRepository.updateUser(id,contactDataItem)

    }
    fun deleteContact(id: String,idOfContact:String):LiveData<Boolean>?{
        contactDelete = ContactRepository.deleteContact(id, idOfContact)
        return contactDelete
    }


}