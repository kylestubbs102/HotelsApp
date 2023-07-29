package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class LinkX(
    @SerializedName("accessibilityString")
    val accessibilityString: AccessibilityString,
    @SerializedName("externalUrl")
    val externalUrl: String,
    @SerializedName("text")
    val text: Text,
    @SerializedName("trackingContext")
    val trackingContext: String,
    @SerializedName("__typename")
    val typename: String
)