package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class CardPhoto(
    @SerializedName("sizes")
    val sizes: Sizes,
    @SerializedName("__typename")
    val typename: String
)