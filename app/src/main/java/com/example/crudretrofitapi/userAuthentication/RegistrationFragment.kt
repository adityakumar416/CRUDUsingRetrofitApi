package com.example.crudretrofitapi.userAuthentication

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.crudretrofitapi.R
import com.example.crudretrofitapi.databinding.FragmentRegistrationBinding
import com.example.crudretrofitapi.userAuthentication.model.signup.UserRequest
import com.example.crudretrofitapi.sharedPreference.Constant
import com.example.crudretrofitapi.sharedPreference.PrefManager
import com.example.crudretrofitapi.userAuthentication.userViewModel.RegistrationViewModel
import com.google.android.material.snackbar.Snackbar

class RegistrationFragment : Fragment() {
 private lateinit var binding:FragmentRegistrationBinding
 private val registrationViewModel: RegistrationViewModel by viewModels()
   // private val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
     lateinit var sharedPreferences:PrefManager

    private var notRegister = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentRegistrationBinding.inflate(inflater, container, false)

        sharedPreferences = PrefManager(requireActivity())

        binding.signUpBtn.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val confirmPassword = binding.confirmPasswordEditText.text.toString()

            if (binding.nameEditText.text!!.isEmpty()) {
                binding.nameEditText.requestFocus()
                Snackbar.make(binding.nameEditText, "Name is Mandatory.", Snackbar.LENGTH_SHORT).show();

            }
         /*   else if (binding.emailEditText.text!!.isEmpty() && email.matches(emailRegex.toRegex())) {
                binding.emailEditText.requestFocus()
                Snackbar.make(binding.emailEditText, "Email is Mandatory.", Snackbar.LENGTH_SHORT).show()
            }*/

            else if (!Patterns.EMAIL_ADDRESS.matcher( binding.emailEditText.text.toString()).matches()) {
                binding.emailEditText.requestFocus()
                Snackbar.make(binding.emailEditText, "Enter a valid Email.", Snackbar.LENGTH_SHORT).show()
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
                    if(notRegister){
                        registrationViewModel.checkUserExist(binding.emailEditText.text.toString())?.observe(viewLifecycleOwner,
                            Observer {  response->
                                if(response){
                                    Toast.makeText(requireContext(),"User Already Exist", Toast.LENGTH_SHORT).show()
                                }
                                else {
                                    val userRequest = UserRequest(name,email,password,confirmPassword)
                                    registrationViewModel.registerUser(userRequest)?.observe(viewLifecycleOwner,
                                        Observer {
                                                        Toast.makeText(
                                                            requireContext(),
                                                            "Registration Successful",
                                                            Toast.LENGTH_SHORT
                                                        ).show()

                                        })
                                   
                                }

                            })
                        notRegister = false
                    }
                else{
                        registrationViewModel.checkUserExist(binding.emailEditText.text.toString())

                    }

                sharedPreferences.userEmail(Constant.PREF_IS_EMAIL,binding.emailEditText.text.toString())

                sharedPreferences.userName(Constant.PREF_IS_NAME,binding.nameEditText.text.toString())

            }
        }

        binding.signIn.setOnClickListener {
            findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)

        }

        return binding.root
    }
}