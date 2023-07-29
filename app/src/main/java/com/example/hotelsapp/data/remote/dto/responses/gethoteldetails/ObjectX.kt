package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class ObjectX(
    @SerializedName("minimumRatingValue")
    val minimumRatingValue: Int?,
    @SerializedName("text")
    val text: String?,
    @SerializedName("__typename")
    val typename: String
)