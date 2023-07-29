package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class TypedParamsX(
    @SerializedName("albumId")
    val albumId: Any?,
    @SerializedName("galleryConfig")
    val galleryConfig: String,
    @SerializedName("locationId")
    val locationId: Int,
    @SerializedName("locationIdStr")
    val locationIdStr: String,
    @SerializedName("offset")
    val offset: Any?,
    @SerializedName("__typename")
    val typename: String
)