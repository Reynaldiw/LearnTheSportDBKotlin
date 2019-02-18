package com.reynaldiwijaya.learnthesportdbkotlin.Presenter

import android.util.Log
import com.reynaldiwijaya.learnthesportdbkotlin.Model.TeamResponse
import com.reynaldiwijaya.learnthesportdbkotlin.NetworkApi.ApiInterface
import com.reynaldiwijaya.learnthesportdbkotlin.Utills
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamPresenter (model : Contract.View) : Contract.Presenter {

    var view : Contract.View? = null

    init {
        view = model
    }

    override fun getData() {
        view?.showLoading()

        val apiClient = ApiInterface.create()
        apiClient.getClub("English Premier League").enqueue(object : Callback<TeamResponse> {

            override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {
                view?.hideLoading()

                if (response.body() != null) {
                    val teamResponse : TeamResponse = response.body()!!

                    view?.showData(teamResponse.teams)
                    Log.d("TAG", teamResponse.teams.toString())
                }
            }

            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                view?.hideLoading()
                view?.showFailureMessage(t.message)
            }

        })
    }

}