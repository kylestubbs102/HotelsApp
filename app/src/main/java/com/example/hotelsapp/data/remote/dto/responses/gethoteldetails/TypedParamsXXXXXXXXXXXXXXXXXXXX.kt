package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class TypedParamsXXXXXXXXXXXXXXXXXXXX(
    @SerializedName("contentId")
    val contentId: String?,
    @SerializedName("contentType")
    val contentType: String,
    @SerializedName("detailId")
    val detailId: Int?,
    @SerializedName("pagee")
    val pagee: String?,
    @SerializedName("routingFilters")
    val routingFilters: Any?,
    @SerializedName("__typename")
    val typename: String
)