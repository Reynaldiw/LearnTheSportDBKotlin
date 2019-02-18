package com.reynaldiwijaya.learnthesportdbkotlin.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.reynaldiwijaya.learnthesportdbkotlin.Model.TeamData
import com.reynaldiwijaya.learnthesportdbkotlin.Presenter.DetailContract
import com.reynaldiwijaya.learnthesportdbkotlin.Presenter.DetailPresenter
import kotlinx.android.synthetic.main.activity_detail.*
import android.support.v4.content.ContextCompat
import android.support.design.widget.CollapsingToolbarLayout
import android.widget.Toast


class DetailActivity : AppCompatActivity(), DetailContract.View {

    private val detailPresenter : DetailPresenter = DetailPresenter(this)
    private lateinit var idTeam : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.reynaldiwijaya.learnthesportdbkotlin.R.layout.activity_detail)

        idTeam = intent.getStringExtra("idClub")
        Log.d("TAG", idTeam)

        detailPresenter.getDetaiTeam(idTeam)


    }

    override fun showProgress() {
        swipeRefresh.isRefreshing = true
    }

    override fun hideProgress() {
        swipeRefresh.isRefreshing = false
    }

    override fun setUpList(detaiTeams: List<TeamData>) {
        tv_name.text = detaiTeams[0].teamName
        tv_tahun.text = detaiTeams[0].sinceYear
        tvContentBerita.text = detaiTeams[0].description
        Glide.with(this)
            .load(detaiTeams[0].imageClub)
            .into(imgClub)
        val collapsingToolbarLayout = findViewById<CollapsingToolbarLayout>(com.reynaldiwijaya.learnthesportdbkotlin.R.id.collapsing)
        collapsingToolbarLayout.title = detaiTeams[0].teamName

        collapsingToolbarLayout.setCollapsedTitleTextColor(
            ContextCompat.getColor(this, android.R.color.white)
        )
        collapsingToolbarLayout.setExpandedTitleColor(
            ContextCompat.getColor(this, android.R.color.darker_gray)
        )
        Glide.with(this)
            .load(detaiTeams[0].imageStadium)
            .into(ivGambarBerita)
    }

    override fun showFailureMessage(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

}
