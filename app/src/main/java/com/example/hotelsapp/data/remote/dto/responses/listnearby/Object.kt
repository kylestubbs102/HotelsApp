package com.example.hotelsapp.data.remote.dto.responses.listnearby


import com.google.gson.annotations.SerializedName

data class Object(
    @SerializedName("placeType")
    val placeType: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("__typename")
    val typename: String
)