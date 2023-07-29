package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class RankingDetailsV2(
    @SerializedName("route")
    val route: RouteXXXXX,
    @SerializedName("text")
    val text: TextXXXXXXX,
    @SerializedName("trackingContext")
    val trackingContext: String,
    @SerializedName("__typename")
    val typename: String
)