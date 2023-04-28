package com.example.crudretrofitapi.sharedPreference

import android.content.Context
import android.content.SharedPreferences

class PrefManager(context: Context) {

    private val sharedPreferences: SharedPreferences
    private val editor:SharedPreferences.Editor


    init {
        sharedPreferences =context.getSharedPreferences("Aditya",Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    fun checkLogin(key:String, value: Boolean){
        editor.putBoolean(key, value)
            .apply()
    }

    fun userName(key: String,value: String){
        editor.putString(key, value)
            .apply()
    }

    fun userId(key: String,value: String){
        editor.putString(key, value)
            .apply()
    }

    fun userEmail(key: String,value: String){
        editor.putString(key, value)
            .apply()
    }

    fun getValue(key: String): String? {
        return sharedPreferences.getString(key,null)
    }

    fun getBoolean(key: String):Boolean{
        return sharedPreferences.getBoolean(key,false)
    }

    fun clear(){
            editor.clear()
                .apply()
    }

}