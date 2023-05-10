package com.example.crudretrofitapi.contactHome.update.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UpdateModel(
    val email: String,
    val name: String,
    val number: String
): Parcelable