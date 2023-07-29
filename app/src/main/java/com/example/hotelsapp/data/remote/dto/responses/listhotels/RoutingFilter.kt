package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class RoutingFilter(
    @SerializedName("id")
    val id: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("value")
    val value: List<String>
)