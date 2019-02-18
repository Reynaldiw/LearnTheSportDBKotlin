package com.reynaldiwijaya.learnthesportdbkotlin.Presenter

import com.reynaldiwijaya.learnthesportdbkotlin.Model.TeamResponse
import com.reynaldiwijaya.learnthesportdbkotlin.NetworkApi.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailPresenter (model : DetailContract.View) : DetailContract.Presenter {

    private var view : DetailContract.View = model

    override fun getDetaiTeam(idTeam: String) {
        view.showProgress()

        val apiClient = ApiInterface.create()
        apiClient.getDetailClub(idTeam).enqueue(object : Callback<TeamResponse> {

            override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {
                view.hideProgress()

                if (response.body() != null) {
                    val teamResponse : TeamResponse = response.body()!!

                    view.setUpList(teamResponse.teams)
                }
            }

            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                view.hideProgress()
                view.showFailureMessage(t.message.toString())
            }

        })
    }
}