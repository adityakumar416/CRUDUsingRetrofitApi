package com.example.crudretrofitapi.contactHome.addContact.model

data class AddContactRequest(
    val email: String,
    val name: String,
    val number: String
)