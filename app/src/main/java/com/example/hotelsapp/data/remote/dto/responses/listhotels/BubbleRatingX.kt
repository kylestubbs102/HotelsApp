package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class BubbleRatingX(
    @SerializedName("numberReviews")
    val numberReviews: NumberReviews,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("__typename")
    val typename: String
)