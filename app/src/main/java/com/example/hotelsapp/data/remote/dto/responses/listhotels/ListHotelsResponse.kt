package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class ListHotelsResponse(
    @SerializedName("data")
    val `data`: Data
)