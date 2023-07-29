package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class CommerceButtons(
    @SerializedName("firstCommerceButton")
    val firstCommerceButton: Any?,
    @SerializedName("secondCommerceButton")
    val secondCommerceButton: Any?,
    @SerializedName("singleButton")
    val singleButton: SingleButton,
    @SerializedName("__typename")
    val typename: String
)