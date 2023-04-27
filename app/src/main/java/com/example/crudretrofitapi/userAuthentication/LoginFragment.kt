package com.example.crudretrofitapi.userAuthentication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.crudretrofitapi.R
import com.example.crudretrofitapi.databinding.FragmentLoginBinding
import com.example.crudretrofitapi.noteHome.DashboardActivity
import com.example.crudretrofitapi.userViewModel.RegistrationViewModel
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {
 private lateinit var binding: FragmentLoginBinding
    private val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
    private val registrationViewModel:RegistrationViewModel by viewModels()
    private var notRegisterLoginObserver= true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.loginBtn.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (binding.emailEditText.text!!.isEmpty() && email.matches(emailRegex.toRegex())) {
                binding.emailEditText.requestFocus()
                Snackbar.make(binding.emailEditText, "Email is Mandatory.", Snackbar.LENGTH_SHORT).show()
            }

            else if (binding.passwordEditText.text!!.isEmpty()) {
                binding.passwordEditText.requestFocus()
                Snackbar.make(binding.passwordEditText, "Password is Mandatory.", Snackbar.LENGTH_SHORT).show();
            }
            else{
                    if (notRegisterLoginObserver){
                        registrationViewModel.loginUser(email, password)?.observe(viewLifecycleOwner,
                            Observer {response->
                                response._id
                                if(response.email.equals("User Not Found")){
                                    Toast.makeText(requireContext(),"Incorrect Password or Email / Or Sign Up",Toast.LENGTH_SHORT).show()

                                }
                                else{
                                    Toast.makeText(requireContext(),"Login Successful", Toast.LENGTH_SHORT).show()
                                    val intent = Intent(requireContext(),DashboardActivity::class.java)
                                    startActivity(intent)


                                }
                            })
                        notRegisterLoginObserver = false
                    }
                else{
                        registrationViewModel.loginUser(email, password)

                    }
            }
        }


        binding.signUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)

        }


        return binding.root
    }

}