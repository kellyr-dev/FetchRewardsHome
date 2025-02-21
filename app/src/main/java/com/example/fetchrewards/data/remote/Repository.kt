package com.example.fetchrewards.data.remote

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val api: FetchApi,
) {
    suspend fun getFetchItem() = api.getFetchItems()

}