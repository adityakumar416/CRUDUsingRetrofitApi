package com.example.crudretrofitapi

import android.app.Activity
import androidx.appcompat.app.AlertDialog

class LoadingDialog(val activity: Activity) {

    private lateinit var isdialog:AlertDialog

    fun startLoading(){
        val infalter = activity.layoutInflater
        val dialogView = infalter.inflate(R.layout.progress_bar,null)
        val builder = AlertDialog.Builder(activity)
        builder.setView(dialogView)
        builder.setCancelable(false)
        isdialog = builder.create()
        isdialog.show()
    }
    fun isDismiss(){
        isdialog.dismiss()
    }


}