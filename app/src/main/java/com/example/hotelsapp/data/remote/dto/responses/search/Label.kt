package com.example.hotelsapp.data.remote.dto.responses.search


import com.google.gson.annotations.SerializedName

data class Label(
    @SerializedName("text")
    val text: TextX,
    @SerializedName("__typename")
    val typename: String
)