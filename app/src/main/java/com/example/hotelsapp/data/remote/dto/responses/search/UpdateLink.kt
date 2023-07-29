package com.example.hotelsapp.data.remote.dto.responses.search


import com.google.gson.annotations.SerializedName

data class UpdateLink(
    @SerializedName("accessibilityString")
    val accessibilityString: AccessibilityString,
    @SerializedName("autoLoad")
    val autoLoad: Boolean,
    @SerializedName("route")
    val route: RouteXX,
    @SerializedName("routeKey")
    val routeKey: RouteKey,
    @SerializedName("text")
    val text: Any?,
    @SerializedName("trackingContext")
    val trackingContext: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("updateToken")
    val updateToken: String
)