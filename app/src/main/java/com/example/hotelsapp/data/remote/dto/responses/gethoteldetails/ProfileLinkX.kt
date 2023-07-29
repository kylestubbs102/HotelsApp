package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class ProfileLinkX(
    @SerializedName("accessibilityString")
    val accessibilityString: AccessibilityString,
    @SerializedName("route")
    val route: RouteXXXXXXXXXXXXXXXX,
    @SerializedName("text")
    val text: Text,
    @SerializedName("trackingContext")
    val trackingContext: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("webviewRoute")
    val webviewRoute: Any?
)