package com.gfg.ricky_morty_recycler_fragments.Home

// Add Gson to your dependencies first
import com.gfg.ricky_morty_recycler_fragments.Data.Data
import com.google.gson.Gson

// This function converts JSON string to your Data class
fun parseJson(jsonString: String): Data {
    val gson = Gson()
    return gson.fromJson(jsonString, Data::class.java)
}