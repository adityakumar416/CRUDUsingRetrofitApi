package com.example.crudretrofitapi.contactHome.displayContact

import com.example.crudretrofitapi.contactHome.addContact.model.AddContactResponse
import com.example.crudretrofitapi.contactHome.displayContact.model.AllContactResponseItem

interface DeleteContact {
    fun deleteContact(allContactResponseItem: AllContactResponseItem)
}