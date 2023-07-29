package com.example.hotelsapp.data.remote.dto.responses.search


import com.google.gson.annotations.SerializedName

data class SearchLocationsResponse(
    @SerializedName("data")
    val `data`: Data
)