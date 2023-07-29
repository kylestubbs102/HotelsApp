package com.example.hotelsapp.data.remote.dto.responses.listnearby


import com.google.gson.annotations.SerializedName

data class ListNearbyLocationsResponse(
    @SerializedName("data")
    val `data`: Data
)