package com.example.crudretrofitapi.contactHome.update

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.crudretrofitapi.R
import com.example.crudretrofitapi.contactHome.addContact.model.AddContactRequest
import com.example.crudretrofitapi.contactHome.addContact.model.AddContactResponse
import com.example.crudretrofitapi.contactHome.displayContact.model.AllContactResponseItem
import com.example.crudretrofitapi.contactHome.displayContact.viewModel.ContactViewModel
import com.example.crudretrofitapi.contactHome.update.model.UpdateModel
import com.example.crudretrofitapi.databinding.FragmentUpdateContactBinding
import com.example.crudretrofitapi.sharedPreference.Constant
import com.example.crudretrofitapi.sharedPreference.PrefManager
import com.google.android.material.snackbar.Snackbar

class UpdateContactFragment : Fragment() {

    private lateinit var binding:FragmentUpdateContactBinding

    private lateinit var prefManager: PrefManager
    private val contactViewModel: ContactViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentUpdateContactBinding.inflate(layoutInflater, container, false)


        prefManager = PrefManager(requireContext())


        binding.updateContact.setOnClickListener {

            val name = binding.updateNameEditText.text.toString()
            val number = binding.updateNumberEditText.text.toString()
            val email = binding.updateEmailEditText.text.toString()


            if (binding.updateNameEditText.text!!.isEmpty()) {
                binding.updateNameEditText.requestFocus()
                Snackbar.make(binding.updateNameEditText, "Name is Mandatory.", Snackbar.LENGTH_SHORT)
                    .show();

            } else if (binding.updateNumberEditText.text!!.isEmpty()) {
                binding.updateNumberEditText.requestFocus()
                Snackbar.make(
                    binding.updateNumberEditText,
                    "Number is Mandatory.",
                    Snackbar.LENGTH_SHORT
                ).show();
            }
            else if (binding.updateEmailEditText.text!!.isEmpty()) {
                binding.updateEmailEditText.requestFocus()
                Snackbar.make(
                    binding.updateEmailEditText,
                    "Email is Mandatory.",
                    Snackbar.LENGTH_SHORT
                ).show();
            }


            else{

                                val id = prefManager.getValue(Constant.PREF_IS_USER_ID)

                                val allContactResponseItem = UpdateModel(email,name,number)
                                contactViewModel.updateContact(id.toString(),allContactResponseItem)
                             Toast.makeText(requireContext(),"Contact is Update", Toast.LENGTH_SHORT).show()
                                Log.i(it.toString(),"User Save Add Fragment")

            }
        }



        return binding.root
    }

}