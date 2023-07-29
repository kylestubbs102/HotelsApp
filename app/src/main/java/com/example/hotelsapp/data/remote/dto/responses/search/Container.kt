package com.example.hotelsapp.data.remote.dto.responses.search


import com.google.gson.annotations.SerializedName

data class Container(
    @SerializedName("searchTitle")
    val searchTitle: SearchTitle,
    @SerializedName("__typename")
    val typename: String
)