package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class SubRatingsX(
    @SerializedName("cleanliness")
    val cleanliness: Double,
    @SerializedName("location")
    val location: Double,
    @SerializedName("service")
    val service: Double,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("value")
    val value: Double
)