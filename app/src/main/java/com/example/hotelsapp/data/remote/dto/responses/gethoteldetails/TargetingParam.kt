package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class TargetingParam(
    @SerializedName("key")
    val key: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("values")
    val values: List<String>
)