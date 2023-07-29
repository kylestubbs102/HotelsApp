package com.example.hotelsapp.data.remote.dto.responses.listhotelfilters


import com.google.gson.annotations.SerializedName

data class ListHotelFiltersResponse(
    @SerializedName("data")
    val `data`: Data
)