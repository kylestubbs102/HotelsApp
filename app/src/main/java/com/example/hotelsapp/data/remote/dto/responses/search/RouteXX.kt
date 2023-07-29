package com.example.hotelsapp.data.remote.dto.responses.search


import com.google.gson.annotations.SerializedName

data class RouteXX(
    @SerializedName("fragment")
    val fragment: Any?,
    @SerializedName("nonCanonicalUrl")
    val nonCanonicalUrl: String,
    @SerializedName("page")
    val page: String,
    @SerializedName("typedParams")
    val typedParams: TypedParamsXX,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("url")
    val url: String
)