package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class Impression(
    @SerializedName("data")
    val `data`: String,
    @SerializedName("__typename")
    val typename: String
)