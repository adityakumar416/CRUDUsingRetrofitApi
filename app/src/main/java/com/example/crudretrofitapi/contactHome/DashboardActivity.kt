package com.example.crudretrofitapi.contactHome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.crudretrofitapi.R
import com.example.crudretrofitapi.databinding.ActivityDashboardBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nevView:BottomNavigationView = binding.bottomNavigationView
        val navController = findNavController(R.id.fragmentContainer)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.add_contact,R.id.show_contact))
        setupActionBarWithNavController(navController,appBarConfiguration)
        nevView.setupWithNavController(navController)


/*

        binding.viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(binding.tabTabLayout,binding.viewPager){
            tab,position->
            when(position){
                0-> tab.text = "Add Contact"
                1->tab.text = "Display Contact"
            }
        }.attach()

*/

    }
}