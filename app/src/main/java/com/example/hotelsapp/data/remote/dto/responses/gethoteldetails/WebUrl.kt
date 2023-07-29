package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class WebUrl(
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