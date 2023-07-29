package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class Sizes(
    @SerializedName("maxHeight")
    val maxHeight: Int,
    @SerializedName("maxWidth")
    val maxWidth: Int,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("urlTemplate")
    val urlTemplate: String
)