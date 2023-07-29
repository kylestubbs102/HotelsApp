package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class TypedParams(
    @SerializedName("contentId")
    val contentId: String,
    @SerializedName("locationId")
    val locationId: Int,
    @SerializedName("__typename")
    val typename: String
)