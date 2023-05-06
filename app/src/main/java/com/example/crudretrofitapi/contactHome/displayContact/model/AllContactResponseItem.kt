package com.example.crudretrofitapi.contactHome.displayContact.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class AllContactResponseItem(
    val _id: String,
    val email: String,
    val name: String,
    val number: String
):Parcelable