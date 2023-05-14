package com.example.crudretrofitapi.contactHome.addContact

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.crudretrofitapi.contactHome.addContact.model.AddContactRequest
import com.example.crudretrofitapi.contactHome.displayContact.model.AllContactResponseItem
import com.example.crudretrofitapi.contactHome.displayContact.viewModel.ContactViewModel
import com.example.crudretrofitapi.databinding.FragmentAddContactBinding
import com.example.crudretrofitapi.sharedPreference.Constant
import com.example.crudretrofitapi.sharedPreference.PrefManager
import com.example.crudretrofitapi.userAuthentication.model.signup.UserRequest
import com.example.crudretrofitapi.userAuthentication.userViewModel.RegistrationViewModel
import com.google.android.material.snackbar.Snackbar


class AddContactFragment : Fragment() {

    private lateinit var binding: FragmentAddContactBinding
    private lateinit var prefManager: PrefManager
    private val contactViewModel: ContactViewModel by viewModels()
    private val registrationViewModel:RegistrationViewModel by viewModels()
    private var notRegister = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentAddContactBinding.inflate(layoutInflater, container, false)



        return binding.root

    }

}