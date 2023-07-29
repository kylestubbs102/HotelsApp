package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class Pax(
    @SerializedName("ageBand")
    val ageBand: String,
    @SerializedName("count")
    val count: Int,
    @SerializedName("endAge")
    val endAge: Any?,
    @SerializedName("maxTravelersPerBooking")
    val maxTravelersPerBooking: Any?,
    @SerializedName("minTravelersPerBooking")
    val minTravelersPerBooking: Any?,
    @SerializedName("startAge")
    val startAge: Any?,
    @SerializedName("__typename")
    val typename: String
)