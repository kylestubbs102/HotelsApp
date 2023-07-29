package com.example.hotelsapp.data.remote.dto.responses.search


import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("accessibilityString")
    val accessibilityString: AccessibilityString?,
    @SerializedName("autoLoad")
    val autoLoad: Boolean?,
    @SerializedName("route")
    val route: RouteXXX,
    @SerializedName("routeKey")
    val routeKey: RouteKey?,
    @SerializedName("text")
    val text: TextX,
    @SerializedName("trackingContext")
    val trackingContext: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("updateToken")
    val updateToken: String?,
    @SerializedName("webviewRoute")
    val webviewRoute: Any?
)