package com.example.crudretrofitapi.userAuthentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.crudretrofitapi.R
import com.example.crudretrofitapi.databinding.FragmentRegistrationBinding
import com.example.crudretrofitapi.model.UserRequest
import com.example.crudretrofitapi.userViewModel.RegistrationViewModel
import com.google.android.material.snackbar.Snackbar

class RegistrationFragment : Fragment() {
 private lateinit var binding:FragmentRegistrationBinding
 private val registrationViewModel:RegistrationViewModel by viewModels()
    private val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentRegistrationBinding.inflate(inflater, container, false)

        binding.signUpBtn.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val confirmPassword = binding.confirmPasswordEditText.text.toString()

            if (binding.nameEditText.text!!.isEmpty()) {
                binding.nameEditText.requestFocus()
                Snackbar.make(binding.nameEditText, "Name is Mandatory.", Snackbar.LENGTH_SHORT).show();

            } else if (binding.emailEditText.text!!.isEmpty()) {
                binding.emailEditText.requestFocus()
                Snackbar.make(binding.emailEditText, "Email is Mandatory.", Snackbar.LENGTH_SHORT).show()
            }
            else if (email.matches(emailRegex.toRegex())) {
                binding.emailEditText.requestFocus()
                Snackbar.make(binding.emailEditText, "Enter a Valid Email.", Snackbar.LENGTH_SHORT).show()

            }
            else if (binding.passwordEditText.text!!.isEmpty()) {
                binding.passwordEditText.requestFocus()
                Snackbar.make(binding.passwordEditText, "Password is Mandatory.", Snackbar.LENGTH_SHORT).show();
            }
            else if (binding.confirmPasswordEditText.text!!.isEmpty()) {
                binding.confirmPasswordEditText.requestFocus()
                Snackbar.make(binding.confirmPasswordEditText, "Confirm Password is Mandatory.", Snackbar.LENGTH_SHORT).show();
            }

            else{
                    val userRequest = UserRequest(name,email,password,confirmPassword)
                    registrationViewModel.registerUser(userRequest)
            }
        }


        return binding.root
    }
}