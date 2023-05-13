package com.example.crudretrofitapi.contactHome.displayContact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crudretrofitapi.contactHome.addContact.model.AddContactResponse
import com.example.crudretrofitapi.contactHome.displayContact.adapter.DisplayContactAdapter
import com.example.crudretrofitapi.contactHome.displayContact.model.AllContactResponse
import com.example.crudretrofitapi.contactHome.displayContact.model.AllContactResponseItem
import com.example.crudretrofitapi.contactHome.displayContact.viewModel.ContactViewModel
import com.example.crudretrofitapi.databinding.FragmentDisplayContactBinding
import com.example.crudretrofitapi.sharedPreference.Constant
import com.example.crudretrofitapi.sharedPreference.PrefManager

class DisplayContactFragment : Fragment(),DeleteContact {

    private lateinit var binding: FragmentDisplayContactBinding
    private val contactViewModel:ContactViewModel by viewModels()
    private lateinit var prefManager:PrefManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentDisplayContactBinding.inflate(inflater, container, false)

        showData()


        return binding.root
    }

    private fun showData() {

        prefManager = PrefManager(requireContext())
        val adapter = DisplayContactAdapter()
        val recyclerView = binding.recyclerView

        recyclerView.adapter = adapter
        adapter.deleteContact = this
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })

        val listObserver = Observer<AllContactResponse>{
                newList->
            adapter.setData(newList)
        }

        val id = prefManager.getValue(Constant.PREF_IS_USER_ID)
        binding.textView3.text = id.toString()
        contactViewModel.getAllContact(id.toString())?.observe(viewLifecycleOwner,listObserver)
    }

    override fun onResume() {
        super.onResume()
        showData()
    }

    override fun deleteContact(allContactResponseItem: AllContactResponseItem) {
        val id = prefManager.getValue(Constant.PREF_IS_USER_ID)
        contactViewModel.deleteContact(id.toString(),allContactResponseItem._id)
        Toast.makeText(requireContext(),"Contact is Delete.", Toast.LENGTH_SHORT).show()


    }

    override fun updateContact(contact: AllContactResponseItem) {
        val action = DisplayContactFragmentDirections.actionShowContactToUpdateContactFragment(contact)
        findNavController().navigate(action)
    }

}