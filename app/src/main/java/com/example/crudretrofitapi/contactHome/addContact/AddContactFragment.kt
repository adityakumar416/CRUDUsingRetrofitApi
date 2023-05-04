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
import com.google.android.material.snackbar.Snackbar


class AddContactFragment : Fragment() {

    private lateinit var binding: FragmentAddContactBinding
    private lateinit var prefManager: PrefManager
    private val contactViewModel: ContactViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentAddContactBinding.inflate(layoutInflater, container, false)

        prefManager = PrefManager(requireContext())

        binding.saveContact.setOnClickListener {

            val name = binding.addNameEditText.text.toString()
            val number = binding.addNumberEditText.text.toString()
            val email = binding.emailEditText.text.toString()


            if (binding.addNameEditText.text!!.isEmpty()) {
                binding.addNameEditText.requestFocus()
                Snackbar.make(binding.addNameEditText, "Name is Mandatory.", Snackbar.LENGTH_SHORT)
                    .show();

            } else if (binding.addNumberEditText.text!!.isEmpty()) {
                binding.addNumberEditText.requestFocus()
                Snackbar.make(
                    binding.addNumberEditText,
                    "Number is Mandatory.",
                    Snackbar.LENGTH_SHORT
                ).show();
            }
            else if (binding.emailEditText.text!!.isEmpty()) {
                binding.emailEditText.requestFocus()
                Snackbar.make(
                    binding.emailEditText,
                    "Email is Mandatory.",
                    Snackbar.LENGTH_SHORT
                ).show();
            }
            else{

                val id = prefManager.getValue(Constant.PREF_IS_USER_ID)

                val contactModel = AddContactRequest(email,name,number)
                contactViewModel.addContact(id.toString(),contactModel)?.observe(viewLifecycleOwner,
                    Observer {
                    Toast.makeText(context,"User is Save", Toast.LENGTH_SHORT).show()


                })



            }


        }





        return binding.root

    }

}