package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class MediumCardsCarouselContent(
    @SerializedName("bubbleRating")
    val bubbleRating: Any?,
    @SerializedName("cardLink")
    val cardLink: CardLink,
    @SerializedName("cardTitle")
    val cardTitle: CardTitle,
    @SerializedName("commerceButtons")
    val commerceButtons: Any?,
    @SerializedName("contributor")
    val contributor: Contributor,
    @SerializedName("descriptiveText")
    val descriptiveText: Any?,
    @SerializedName("labels")
    val labels: List<Any>,
    @SerializedName("primaryInfo")
    val primaryInfo: PrimaryInfo,
    @SerializedName("secondaryInfo")
    val secondaryInfo: Any?,
    @SerializedName("stableDiffingType")
    val stableDiffingType: String,
    @SerializedName("trackingKey")
    val trackingKey: String,
    @SerializedName("trackingTitle")
    val trackingTitle: String,
    @SerializedName("__typename")
    val typename: String
)