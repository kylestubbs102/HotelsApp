package com.example.hotelsapp.data.remote.dto.responses.gethoteloffers


import com.google.gson.annotations.SerializedName

data class GetHotelOffersResponse(
    @SerializedName("data")
    val `data`: Data
)