package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class RouteXXXXXXXXXXXXXX(
    @SerializedName("fragment")
    val fragment: Any?,
    @SerializedName("nonCanonicalUrl")
    val nonCanonicalUrl: String,
    @SerializedName("page")
    val page: String,
    @SerializedName("typedParams")
    val typedParams: TypedParamsXXXXXXXXXXXXXXX,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("url")
    val url: String
)