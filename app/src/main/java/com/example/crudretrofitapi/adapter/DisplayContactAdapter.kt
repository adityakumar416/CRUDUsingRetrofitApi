package com.example.crudretrofitapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crudretrofitapi.R

class DisplayContactAdapter: RecyclerView.Adapter<DisplayContactAdapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item,parent,false)

        return ViewHolder(view)

        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {

        return 5

    }


}