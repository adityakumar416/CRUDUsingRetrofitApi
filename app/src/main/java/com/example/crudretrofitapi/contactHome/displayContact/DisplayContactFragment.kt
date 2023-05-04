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
import com.example.crudretrofitapi.sharedPreference.Constant
import com.example.crudretrofitapi.sharedPreference.PrefManager

class DisplayContactFragment : Fragment() {

    private lateinit var binding: FragmentDisplayContactBinding
    private val contactViewModel:ContactViewModel by viewModels()
    private lateinit var prefManager:PrefManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentDisplayContactBinding.inflate(inflater, container, false)

        prefManager = PrefManager(requireContext())
        val adapter = DisplayContactAdapter()
        val recyclerView = binding.recyclerView

        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

       val listObserver = Observer<AllContactResponse>{
            newList->
           adapter.setData(newList)
       }

        val id = prefManager.getValue(Constant.PREF_IS_USER_ID)
        binding.textView3.text = id.toString()
        contactViewModel.getAllContact(id.toString())?.observe(viewLifecycleOwner,listObserver)



        return binding.root
    }

}