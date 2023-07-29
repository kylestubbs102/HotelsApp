package com.example.hotelsapp.data.remote.dto.requests.listnearby


import com.google.gson.annotations.SerializedName

data class SouthWestCorner(
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double
)