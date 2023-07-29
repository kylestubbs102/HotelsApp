package com.example.hotelsapp.data.remote.dto.responses.listnearby


import com.google.gson.annotations.SerializedName

data class MapSection(
    @SerializedName("anchor")
    val anchor: Anchor?,
    @SerializedName("center")
    val center: Center?,
    @SerializedName("clusterId")
    val clusterId: String,
    @SerializedName("content")
    val content: List<Content>?,
    @SerializedName("pins")
    val pins: List<Pin>?,
    @SerializedName("stableDiffingType")
    val stableDiffingType: String,
    @SerializedName("trackingKey")
    val trackingKey: String,
    @SerializedName("trackingTitle")
    val trackingTitle: String,
    @SerializedName("__typename")
    val typename: String
)