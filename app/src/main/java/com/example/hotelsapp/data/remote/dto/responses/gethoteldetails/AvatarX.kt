package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class AvatarX(
    @SerializedName("data")
    val `data`: DataXXXX,
    @SerializedName("__typename")
    val typename: String
)