package com.example.crudretrofitapi.noteHome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crudretrofitapi.R
import com.example.crudretrofitapi.adapter.DisplayContactAdapter
import com.example.crudretrofitapi.databinding.FragmentDisplayContactBinding

class DisplayContactFragment : Fragment() {

    private lateinit var binding: FragmentDisplayContactBinding

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


        binding.recyclerView



        return binding.root
    }

}