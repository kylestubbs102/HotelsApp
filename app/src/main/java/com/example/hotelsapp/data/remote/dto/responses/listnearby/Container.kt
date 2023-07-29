package com.example.hotelsapp.data.remote.dto.responses.listnearby


import com.google.gson.annotations.SerializedName

data class Container(
    @SerializedName("navTitle")
    val navTitle: String,
    @SerializedName("__typename")
    val typename: String
)