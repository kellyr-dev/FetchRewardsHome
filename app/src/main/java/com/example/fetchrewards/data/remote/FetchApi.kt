package com.example.fetchrewards.data.remote

import com.example.fetchrewards.data.model.ItemModel
import com.example.fetchrewards.data.model.Items
import com.example.fetchrewards.util.Constants
import retrofit2.Response
import retrofit2.http.GET

interface FetchApi {

    @GET(Constants.RANDOM_URL)
    suspend fun getFetchItems(): Response<List<ItemModel>>

}