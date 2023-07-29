package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class BarItem(
    @SerializedName("buttonText")
    val buttonText: ButtonText?,
    @SerializedName("stableDiffingType")
    val stableDiffingType: String,
    @SerializedName("surfaces")
    val surfaces: List<String>,
    @SerializedName("trackingKey")
    val trackingKey: String,
    @SerializedName("trackingTitle")
    val trackingTitle: String,
    @SerializedName("__typename")
    val typename: String
)