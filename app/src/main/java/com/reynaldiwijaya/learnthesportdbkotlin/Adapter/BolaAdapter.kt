package com.reynaldiwijaya.learnthesportdbkotlin.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.reynaldiwijaya.learnthesportdbkotlin.Model.TeamData
import com.reynaldiwijaya.learnthesportdbkotlin.R
import kotlinx.android.synthetic.main.item_club.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class BolaAdapter (val context: Context, val teamDataItems : List<TeamData>, val listener : (TeamData) -> Unit) : RecyclerView.Adapter<BolaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_club, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return teamDataItems.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItems(teamDataItems[p1], listener)
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val namaClub = view.tv_team
        val gambarClub = view.img_club

        fun bindItems (teamData : TeamData, listener: (TeamData) -> Unit) {
            namaClub.text = teamData.teamName
            Glide.with(itemView.context)
                .load(teamData.imageClub)
                .into(gambarClub)
            itemView.onClick {
                listener(teamData)
            }
        }

    }
}