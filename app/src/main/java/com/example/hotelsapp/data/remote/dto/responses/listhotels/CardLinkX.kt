package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class CardLinkX(
    @SerializedName("accessibilityString")
    val accessibilityString: Any?,
    @SerializedName("route")
    val route: RouteXX,
    @SerializedName("text")
    val text: Any?,
    @SerializedName("trackingContext")
    val trackingContext: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("webviewRoute")
    val webviewRoute: Any?
)