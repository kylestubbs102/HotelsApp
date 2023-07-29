package com.example.hotelsapp.data.remote.dto.responses.search


import com.google.gson.annotations.SerializedName

data class Text(
    @SerializedName("text")
    val text: String,
    @SerializedName("__typename")
    val typename: String
)