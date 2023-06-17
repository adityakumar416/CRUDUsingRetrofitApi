package com.example.crudretrofitapi.contactHome.displayContact.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
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
import java.util.*

class DisplayContactAdapter: RecyclerView.Adapter<DisplayContactAdapter.ViewHolder>(),Filterable {

    private var contactList = AllContactResponse()
    private var contactListCopy = AllContactResponse()
    var filteredItemList = contactList
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
        contactListCopy = this.contactList
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                var filteredList = AllContactResponse()
                if(constraint.isNullOrBlank()){
                    filteredList = contactListCopy
                }
                else{
                    val filterPattern = constraint.toString().toLowerCase(Locale.ROOT).trim()
                    contactListCopy.forEach {
                        item->
                        if(item.name.toLowerCase(Locale.ROOT).contains(filterPattern) || item.number.contains(filterPattern) || item.email.contains(filterPattern)){
                            filteredList.add(item)
                        }
                    }
                }
                val filterResults = FilterResults()
                filterResults.values = filteredList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredItemList = results?.values as AllContactResponse
                contactList = filteredItemList
                notifyDataSetChanged()
            }
        }
    }


}