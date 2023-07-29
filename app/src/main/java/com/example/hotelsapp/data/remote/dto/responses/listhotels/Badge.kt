package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class Badge(
    @SerializedName("badgeDetails")
    val badgeDetails: Any?,
    @SerializedName("size")
    val size: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("year")
    val year: String
)