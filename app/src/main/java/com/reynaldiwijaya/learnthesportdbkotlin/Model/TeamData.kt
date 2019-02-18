package com.reynaldiwijaya.learnthesportdbkotlin.Model

import com.google.gson.annotations.SerializedName

data class TeamData (
    @SerializedName("idTeam")
    val teamId: String? = null,

    @SerializedName("strTeam")
    val teamName: String? = null,

    @SerializedName("intFormedYear")
    val sinceYear: String? = null,

    @SerializedName("strDescriptionEN")
    val description: String? = null,

    @SerializedName("strTeamBadge")
    val imageClub : String? = null,

    @SerializedName("strStadiumThumb")
    val imageStadium : String? = null,

    @SerializedName("strStadiumDescription")
    val descriptionStadium : String? = null
)