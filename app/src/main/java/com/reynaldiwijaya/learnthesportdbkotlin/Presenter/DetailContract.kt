package com.reynaldiwijaya.learnthesportdbkotlin.Presenter

import com.reynaldiwijaya.learnthesportdbkotlin.Model.TeamData

interface DetailContract {
    interface View {
        fun showProgress()
        fun hideProgress()
        fun setUpList(detaiTeams : List<TeamData>)
        fun showFailureMessage(error : String)
    }
    interface Presenter {
        fun getDetaiTeam(idTeam : String)
    }
}