package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class SubRatings(
    @SerializedName("data")
    val `data`: DataXXX,
    @SerializedName("__typename")
    val typename: String
)