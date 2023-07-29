package com.example.hotelsapp.data.remote.dto.requests.listhotels


import com.google.gson.annotations.SerializedName

data class NorthEastCorner(
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double
)