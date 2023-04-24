package com.example.crudretrofitapi.userViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crudretrofitapi.model.UserRequest
import com.example.crudretrofitapi.model.UserResponse
import com.example.crudretrofitapi.repository.UserRepository

class RegistrationViewModel:ViewModel() {

    private var registrationViewModel: MutableLiveData<UserResponse>? = null

            fun registerUser(userRequest: UserRequest): LiveData<UserResponse>?{
                registrationViewModel = UserRepository.registerUser(userRequest)
                return registrationViewModel
            }

    fun loginUser(userRequest: UserRequest): LiveData<UserResponse>?{
        registrationViewModel = UserRepository.loginUser(userRequest)
        return registrationViewModel
    }


}