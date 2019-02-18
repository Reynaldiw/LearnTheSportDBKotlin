package com.reynaldiwijaya.learnthesportdbkotlin.Presenter

import com.reynaldiwijaya.learnthesportdbkotlin.Model.TeamData

interface Contract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun showData(listDataItems : List<TeamData>)
        fun showFailureMessage(error : String? = null)
    }
    interface Presenter {
        fun getData()
    }
}