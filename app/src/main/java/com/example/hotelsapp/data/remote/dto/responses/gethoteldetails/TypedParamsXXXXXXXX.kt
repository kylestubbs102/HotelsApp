package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class TypedParamsXXXXXXXX(
    @SerializedName("contentId")
    val contentId: String,
    @SerializedName("contentType")
    val contentType: String,
    @SerializedName("geoId")
    val geoId: Any?,
    @SerializedName("routingFilters")
    val routingFilters: Any?,
    @SerializedName("__typename")
    val typename: String
)