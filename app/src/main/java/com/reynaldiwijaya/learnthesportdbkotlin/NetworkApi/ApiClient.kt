package com.reynaldiwijaya.learnthesportdbkotlin.NetworkApi

import com.reynaldiwijaya.learnthesportdbkotlin.Model.TeamResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("api/v1/json/1/search_all_teams.php")
    fun getClub(@Query("l") league: String) : Call<TeamResponse>

    @GET("api/v1/json/1/lookupteam.php")
    fun getDetailClub(@Query("id") idClub: String) : Call<TeamResponse>
}