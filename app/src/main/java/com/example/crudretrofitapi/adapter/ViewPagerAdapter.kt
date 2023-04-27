package com.example.crudretrofitapi.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.crudretrofitapi.noteHome.AddContactFragment
import com.example.crudretrofitapi.noteHome.DisplayContactFragment

class ViewPagerAdapter(activity:FragmentActivity):FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> AddContactFragment()
            1 -> DisplayContactFragment()

            else -> throw IllegalArgumentException("Invalid Position: $position")
        }
    }
}