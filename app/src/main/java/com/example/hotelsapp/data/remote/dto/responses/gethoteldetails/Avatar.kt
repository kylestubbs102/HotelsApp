package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class Avatar(
    @SerializedName("data")
    val `data`: DataXX,
    @SerializedName("__typename")
    val typename: String
)