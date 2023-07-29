package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class TypedParamsXXXXXXX(
    @SerializedName("contentType")
    val contentType: String,
    @SerializedName("detailId")
    val detailId: Int,
    @SerializedName("pagee")
    val pagee: Any?,
    @SerializedName("routingFilters")
    val routingFilters: Any?,
    @SerializedName("__typename")
    val typename: String
)