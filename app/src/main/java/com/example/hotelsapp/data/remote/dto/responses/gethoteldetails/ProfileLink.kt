package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class ProfileLink(
    @SerializedName("accessibilityString")
    val accessibilityString: AccessibilityString,
    @SerializedName("route")
    val route: RouteXXXXXXXXXXXXX,
    @SerializedName("text")
    val text: Text,
    @SerializedName("trackingContext")
    val trackingContext: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("webviewRoute")
    val webviewRoute: Any?
)