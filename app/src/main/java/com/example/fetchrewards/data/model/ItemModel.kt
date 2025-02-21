package com.example.fetchrewards.data.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ItemModel(
    @SerializedName("id")
    val id: Int = -1,
    @SerializedName("listId")
    val listId: Int = -1,
    @SerializedName("name")
    val name: String = ""
) : Serializable