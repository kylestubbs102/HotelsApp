package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class StickyFooter(
    @SerializedName("cta")
    val cta: Cta,
    @SerializedName("displayPrice")
    val displayPrice: Any?,
    @SerializedName("strikeThroughPrice")
    val strikeThroughPrice: Any?,
    @SerializedName("text")
    val text: Text,
    @SerializedName("__typename")
    val typename: String
)