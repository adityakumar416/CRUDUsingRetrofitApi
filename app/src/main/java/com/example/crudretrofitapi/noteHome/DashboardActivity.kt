package com.example.crudretrofitapi.noteHome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crudretrofitapi.R
import com.example.crudretrofitapi.adapter.ViewPagerAdapter
import com.example.crudretrofitapi.databinding.ActivityDashboardBinding
import com.google.android.material.tabs.TabLayoutMediator

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(binding.tabTabLayout,binding.viewPager){
            tab,position->
            when(position){
                0-> tab.text = "Add Contact"
                1->tab.text = "Display Contact"
            }
        }.attach()


    }
}