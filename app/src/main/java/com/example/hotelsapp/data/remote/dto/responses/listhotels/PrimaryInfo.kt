package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class PrimaryInfo(
    @SerializedName("text")
    val text: String,
    @SerializedName("__typename")
    val typename: String
)