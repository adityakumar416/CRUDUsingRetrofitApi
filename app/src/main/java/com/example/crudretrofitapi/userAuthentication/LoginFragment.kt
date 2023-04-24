package com.example.crudretrofitapi.userAuthentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.crudretrofitapi.databinding.FragmentLoginBinding
import com.example.crudretrofitapi.userViewModel.RegistrationViewModel
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {
 private lateinit var binding: FragmentLoginBinding
    private val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
    val registrationViewModel:RegistrationViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.loginBtn.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (binding.emailEditText.text!!.isEmpty()) {
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
            else{



            }


        }


        return binding.root
    }

}