package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class GetHotelDetailsResponse(
    @SerializedName("data")
    val `data`: Data
)