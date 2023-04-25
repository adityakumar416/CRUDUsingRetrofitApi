package com.example.crudretrofitapi.userViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crudretrofitapi.model.ParticularUserResponseItem
import com.example.crudretrofitapi.model.UserRequest
import com.example.crudretrofitapi.model.UserResponse
import com.example.crudretrofitapi.repository.UserRepository

class RegistrationViewModel:ViewModel() {

    private var registrationViewModel: MutableLiveData<UserResponse>? = null
    private var userExistLiveData : MutableLiveData<Boolean>?=null
    private var particularUserResponseItem: MutableLiveData<ParticularUserResponseItem>? = null

            fun registerUser(userRequest: UserRequest): LiveData<UserResponse>?{
                registrationViewModel = UserRepository.registerUser(userRequest)
                return registrationViewModel
            }

    fun checkUserExist(email: String): LiveData<Boolean>?{
        userExistLiveData = UserRepository.checkUserExist(email)
        return userExistLiveData
    }

    fun loginUser(email: String,password:String):LiveData<ParticularUserResponseItem>?{

        particularUserResponseItem= UserRepository.loginUser(email, password)

        return particularUserResponseItem

    }


}