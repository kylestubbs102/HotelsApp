package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class Tab(
    @SerializedName("content")
    val content: List<Content>,
    @SerializedName("initialTab")
    val initialTab: Boolean?,
    @SerializedName("searchLink")
    val searchLink: SearchLink?,
    @SerializedName("seeMoreV2")
    val seeMoreV2: SeeMoreV2,
    @SerializedName("tabSearchHint")
    val tabSearchHint: TabSearchHint?,
    @SerializedName("tabTitle")
    val tabTitle: TabTitle,
    @SerializedName("tooltip")
    val tooltip: Any?,
    @SerializedName("__typename")
    val typename: String
)