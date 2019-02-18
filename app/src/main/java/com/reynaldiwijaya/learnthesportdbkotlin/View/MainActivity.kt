package com.reynaldiwijaya.learnthesportdbkotlin.View

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.reynaldiwijaya.learnthesportdbkotlin.Adapter.BolaAdapter
import com.reynaldiwijaya.learnthesportdbkotlin.Model.TeamData
import com.reynaldiwijaya.learnthesportdbkotlin.Presenter.Contract
import com.reynaldiwijaya.learnthesportdbkotlin.Presenter.TeamPresenter
import com.reynaldiwijaya.learnthesportdbkotlin.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class MainActivity : AppCompatActivity(), Contract.View {

    var teamPresenter : TeamPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        teamPresenter = TeamPresenter(this)

        teamPresenter?.getData()

        swipeRefresh.setOnRefreshListener {
            teamPresenter?.getData()
        }

    }

    override fun showLoading() {
        swipeRefresh.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefresh.isRefreshing = false
    }

    override fun showData(listDataItems: List<TeamData>) {
        rv_main.layoutManager = LinearLayoutManager(this)
        rv_main.adapter = BolaAdapter(this, listDataItems)
    }

    override fun showFailureMessage(error: String?) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

}
