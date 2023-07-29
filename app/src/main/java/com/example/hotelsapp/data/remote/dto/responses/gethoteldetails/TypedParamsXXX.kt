package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class TypedParamsXXX(
    @SerializedName("contentId")
    val contentId: String,
    @SerializedName("contentType")
    val contentType: String,
    @SerializedName("spAttributionToken")
    val spAttributionToken: Any?,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("wasPlusShown")
    val wasPlusShown: Any?
)