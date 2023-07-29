package com.example.hotelsapp.data.remote.dto.responses.search


import com.google.gson.annotations.SerializedName

data class ChipContent(
    @SerializedName("bubbleRating")
    val bubbleRating: Any?,
    @SerializedName("icon")
    val icon: Any?,
    @SerializedName("selected")
    val selected: Boolean,
    @SerializedName("stableDiffingType")
    val stableDiffingType: String,
    @SerializedName("title")
    val title: Title,
    @SerializedName("trackingKey")
    val trackingKey: String,
    @SerializedName("trackingTitle")
    val trackingTitle: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("updateLink")
    val updateLink: UpdateLink
)