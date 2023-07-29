package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class Subrating(
    @SerializedName("label")
    val label: Label,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("value")
    val value: ValueXX
)