package com.reynaldiwijaya.learnthesportdbkotlin.NetworkApi

import com.reynaldiwijaya.learnthesportdbkotlin.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiInterface {

    fun create(): ApiClient {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()

        return retrofit.create(ApiClient::class.java)
    }

}