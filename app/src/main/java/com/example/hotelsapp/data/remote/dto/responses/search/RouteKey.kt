package com.example.hotelsapp.data.remote.dto.responses.search


import com.google.gson.annotations.SerializedName

data class RouteKey(
    @SerializedName("fragment")
    val fragment: Any?,
    @SerializedName("nonCanonicalUrl")
    val nonCanonicalUrl: Any?,
    @SerializedName("page")
    val page: String,
    @SerializedName("typedParams")
    val typedParams: Any?,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("url")
    val url: Any?
)