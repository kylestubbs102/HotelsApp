package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class NonNullContent(
    @SerializedName("bubbleRating")
    val bubbleRating: BubbleRating,
    @SerializedName("cardLink")
    val cardLink: CardLink,
    @SerializedName("cardPhoto")
    val cardPhoto: CardPhoto?,
    @SerializedName("cardTitle")
    val cardTitle: CardTitle,
    @SerializedName("distance")
    val distance: Distance,
    @SerializedName("primaryInfo")
    val primaryInfo: PrimaryInfo,
    @SerializedName("stableDiffingType")
    val stableDiffingType: String,
    @SerializedName("trackingKey")
    val trackingKey: String,
    @SerializedName("trackingTitle")
    val trackingTitle: String,
    @SerializedName("__typename")
    val typename: String
)