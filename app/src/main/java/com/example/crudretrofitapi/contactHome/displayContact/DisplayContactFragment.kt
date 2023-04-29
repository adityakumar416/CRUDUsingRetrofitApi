package com.example.crudretrofitapi.contactHome.displayContact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crudretrofitapi.contactHome.displayContact.adapter.DisplayContactAdapter
import com.example.crudretrofitapi.contactHome.displayContact.model.AllContactResponse
import com.example.crudretrofitapi.contactHome.displayContact.viewModel.ContactViewModel
import com.example.crudretrofitapi.databinding.FragmentDisplayContactBinding
import com.example.crudretrofitapi.sharedPreference.PrefManager

class DisplayContactFragment : Fragment() {

    private lateinit var binding: FragmentDisplayContactBinding
    private val contactViewModel:ContactViewModel by viewModels()
    private val prefManager:PrefManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentDisplayContactBinding.inflate(inflater, container, false)

        val adapter = DisplayContactAdapter()
        val recyclerView = binding.recyclerView

        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

       val listObserver = Observer<AllContactResponse>{
            newList->
           adapter.setData(newList)
       }



        contactViewModel.getAllContact()?.observe(viewLifecycleOwner,listObserver)



        return binding.root
    }

}