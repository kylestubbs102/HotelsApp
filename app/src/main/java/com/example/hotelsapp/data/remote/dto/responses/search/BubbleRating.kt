package com.example.hotelsapp.data.remote.dto.responses.search


import com.google.gson.annotations.SerializedName

data class BubbleRating(
    @SerializedName("numberReviews")
    val numberReviews: NumberReviews,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("__typename")
    val typename: String
)