package com.example.hotelsapp.data.remote.dto.responses.gethoteloffers


import com.google.gson.annotations.SerializedName

data class CommerceLink(
    @SerializedName("accessibilityString")
    val accessibilityString: Any?,
    @SerializedName("externalUrl")
    val externalUrl: String,
    @SerializedName("text")
    val text: Text,
    @SerializedName("trackingContext")
    val trackingContext: String,
    @SerializedName("__typename")
    val typename: String
)