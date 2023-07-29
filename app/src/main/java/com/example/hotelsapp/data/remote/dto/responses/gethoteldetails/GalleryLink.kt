package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class GalleryLink(
    @SerializedName("accessibilityString")
    val accessibilityString: Any?,
    @SerializedName("route")
    val route: RouteX,
    @SerializedName("text")
    val text: Any?,
    @SerializedName("trackingContext")
    val trackingContext: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("webviewRoute")
    val webviewRoute: Any?
)