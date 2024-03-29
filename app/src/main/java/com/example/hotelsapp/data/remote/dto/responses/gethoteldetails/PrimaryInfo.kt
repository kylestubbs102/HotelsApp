package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class PrimaryInfo(
    @SerializedName("text")
    val text: String,
    @SerializedName("string")
    val string: String,
    @SerializedName("__typename")
    val typename: String
)