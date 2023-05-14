package com.example.crudretrofitapi.userAuthentication.userViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crudretrofitapi.userAuthentication.model.getAllUser.ParticularUserResponseItem
import com.example.crudretrofitapi.userAuthentication.model.signup.UserRequest
import com.example.crudretrofitapi.userAuthentication.model.signup.UserResponse
import com.example.crudretrofitapi.userAuthentication.repository.UserRepository

class RegistrationViewModel:ViewModel() {

    private var registrationViewModel: MutableLiveData<UserResponse>? = null
    private var userExistLiveData : MutableLiveData<Boolean>?=null
    private var particularUserResponseItem: MutableLiveData<ParticularUserResponseItem>? = null

            suspend fun registerUser(userRequest: UserRequest): LiveData<UserResponse>?{
                registrationViewModel = UserRepository.registerUser(userRequest)
                return registrationViewModel
            }

    suspend fun checkUserExist(email: String): LiveData<Boolean>?{
        userExistLiveData = UserRepository.checkUserExist(email)
        return userExistLiveData
    }

    suspend fun loginUser(email: String,password:String):LiveData<ParticularUserResponseItem>?{

        particularUserResponseItem= UserRepository.loginUser(email, password)

        return particularUserResponseItem

    }


}