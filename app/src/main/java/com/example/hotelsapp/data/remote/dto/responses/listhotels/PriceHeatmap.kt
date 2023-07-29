package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class PriceHeatmap(
    @SerializedName("averageDays")
    val averageDays: List<String>,
    @SerializedName("cheapDays")
    val cheapDays: List<String>,
    @SerializedName("highDays")
    val highDays: List<String>,
    @SerializedName("__typename")
    val typename: String
)