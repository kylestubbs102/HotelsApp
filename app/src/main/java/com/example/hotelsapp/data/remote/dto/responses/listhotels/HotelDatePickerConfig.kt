package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class HotelDatePickerConfig(
    @SerializedName("maxStayLength")
    val maxStayLength: Int,
    @SerializedName("__typename")
    val typename: String
)