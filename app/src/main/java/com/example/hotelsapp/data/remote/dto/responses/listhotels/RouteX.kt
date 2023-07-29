package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class RouteX(
    @SerializedName("fragment")
    val fragment: Any?,
    @SerializedName("nonCanonicalUrl")
    val nonCanonicalUrl: String,
    @SerializedName("page")
    val page: String,
    @SerializedName("typedParams")
    val typedParams: TypedParamsX,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("url")
    val url: String
)