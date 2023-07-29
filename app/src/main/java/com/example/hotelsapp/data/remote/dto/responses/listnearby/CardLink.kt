package com.example.hotelsapp.data.remote.dto.responses.listnearby


import com.google.gson.annotations.SerializedName

data class CardLink(
    @SerializedName("accessibilityString")
    val accessibilityString: AccessibilityString,
    @SerializedName("route")
    val route: Route,
    @SerializedName("text")
    val text: Any?,
    @SerializedName("trackingContext")
    val trackingContext: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("webviewRoute")
    val webviewRoute: Any?
)