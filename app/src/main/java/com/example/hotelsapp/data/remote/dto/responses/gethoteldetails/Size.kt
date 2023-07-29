package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class Size(
    @SerializedName("height")
    val height: Int,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)