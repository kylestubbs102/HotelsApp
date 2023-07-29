package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class DatePicker(
    @SerializedName("commerceType")
    val commerceType: String,
    @SerializedName("configuration")
    val configuration: Configuration,
    @SerializedName("lastSelectableDate")
    val lastSelectableDate: String,
    @SerializedName("surfaces")
    val surfaces: List<String>,
    @SerializedName("timeZoneOffset")
    val timeZoneOffset: String,
    @SerializedName("__typename")
    val typename: String
)