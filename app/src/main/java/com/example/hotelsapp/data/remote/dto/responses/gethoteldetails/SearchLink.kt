package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class SearchLink(
    @SerializedName("accessibilityString")
    val accessibilityString: Any?,
    @SerializedName("route")
    val route: RouteXXXXXXXXXXXXXXXXXX,
    @SerializedName("text")
    val text: Text,
    @SerializedName("trackingContext")
    val trackingContext: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("webviewRoute")
    val webviewRoute: Any?
)