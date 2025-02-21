package com.example.fetchrewards.di

import android.util.Log
import com.example.fetchrewards.data.remote.FetchApi
import com.example.fetchrewards.data.remote.Repository
import com.example.fetchrewards.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient =
        OkHttpClient
            .Builder()
            .connectTimeout(60 * 60, TimeUnit.SECONDS)
            .readTimeout(60 * 60, TimeUnit.SECONDS)
            .writeTimeout(60 * 60, TimeUnit.SECONDS)
            .build()

    @Provides
    @Singleton
    fun provideApi(client: OkHttpClient): FetchApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        Log.d("AppModule", "retrofit instance created: $retrofit")

        return retrofit.create(FetchApi::class.java)
    }
}