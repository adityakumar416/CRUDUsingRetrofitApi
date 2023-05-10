package com.example.crudretrofitapi.contactHome.displayContact.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.crudretrofitapi.R
import com.example.crudretrofitapi.contactHome.displayContact.DeleteContact

import com.example.crudretrofitapi.contactHome.displayContact.model.AllContactResponse
import com.example.crudretrofitapi.contactHome.displayContact.model.AllContactResponseItem
import com.example.crudretrofitapi.contactHome.displayContact.repository.ContactRepository.deleteContact
import de.hdodenhof.circleimageview.CircleImageView

class DisplayContactAdapter: RecyclerView.Adapter<DisplayContactAdapter.ViewHolder>() {

    private var contactList = AllContactResponse()
    var deleteContact:DeleteContact?=null

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {

        val name : TextView = view.findViewById(R.id.contact_name)
        val number : TextView = view.findViewById(R.id.contact_number)
        val email : TextView = view.findViewById(R.id.contact_email)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item,parent,false)

        return ViewHolder(view)

        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.name.text = contactList.get(position).name.toString()
        holder.number.text = contactList.get(position).number.toString()
        holder.email.text = contactList.get(position).email.toString()

        holder.itemView.findViewById<CircleImageView>(R.id.delete_item).setOnClickListener {

            deleteContact?.deleteContact(contactList[position])

        }
        holder.itemView.findViewById<CardView>(R.id.contact_item).setOnClickListener {
            deleteContact?.updateContact(contactList[position])
        }
    }

    override fun getItemCount(): Int {

        return contactList.size

    }
    fun setData(contactList:AllContactResponse){
        this.contactList = contactList
        notifyDataSetChanged()
    }


}