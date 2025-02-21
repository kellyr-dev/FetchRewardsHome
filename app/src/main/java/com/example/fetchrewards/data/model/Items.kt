package com.example.fetchrewards.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Items(
   @SerializedName("")
    val products: List<ItemModel>,

) : Serializable