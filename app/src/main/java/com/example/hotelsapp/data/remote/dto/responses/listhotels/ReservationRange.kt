package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class ReservationRange(
    @SerializedName("maxDate")
    val maxDate: String,
    @SerializedName("maxTime")
    val maxTime: String,
    @SerializedName("minDate")
    val minDate: String,
    @SerializedName("minTime")
    val minTime: String,
    @SerializedName("__typename")
    val typename: String
)