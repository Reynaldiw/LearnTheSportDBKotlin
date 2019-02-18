package com.reynaldiwijaya.learnthesportdbkotlin.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.reynaldiwijaya.learnthesportdbkotlin.Adapter.BolaAdapter
import com.reynaldiwijaya.learnthesportdbkotlin.Model.TeamData
import com.reynaldiwijaya.learnthesportdbkotlin.Presenter.Contract
import com.reynaldiwijaya.learnthesportdbkotlin.Presenter.TeamPresenter
import com.reynaldiwijaya.learnthesportdbkotlin.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk25.coroutines.onItemSelectedListener

class MainActivity : AppCompatActivity(), Contract.View {

    private lateinit var teamPresenter : TeamPresenter
    private lateinit var league : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerItem  = resources.getStringArray(R.array.liga)
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerItem)

        teamPresenter = TeamPresenter(this)

        swipeRefresh.setOnRefreshListener {
            teamPresenter.getData(league)
        }

       spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

           override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
               league = spinner.selectedItem.toString()
               teamPresenter.getData(league)
           }

           override fun onNothingSelected(parent: AdapterView<*>?) {
           }
       }

    }

    override fun showLoading() {
        swipeRefresh.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefresh.isRefreshing = false
    }

    override fun showData(listDataItems: List<TeamData>) {
        rv_main.hasFixedSize()
        rv_main.layoutManager = LinearLayoutManager(this)
        rv_main.adapter = BolaAdapter(this, listDataItems)
    }

    override fun showFailureMessage(error: String?) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

}
