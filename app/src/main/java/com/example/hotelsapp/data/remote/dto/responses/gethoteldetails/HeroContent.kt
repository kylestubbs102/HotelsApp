package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class HeroContent(
    @SerializedName("data")
    val `data`: DataX,
    @SerializedName("__typename")
    val typename: String
)