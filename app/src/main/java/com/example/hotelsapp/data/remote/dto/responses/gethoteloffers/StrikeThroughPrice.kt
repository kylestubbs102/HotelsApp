package com.example.hotelsapp.data.remote.dto.responses.gethoteloffers


import com.google.gson.annotations.SerializedName

data class StrikeThroughPrice(
    @SerializedName("debugValueKey")
    val debugValueKey: Any?,
    @SerializedName("string")
    val string: String,
    @SerializedName("__typename")
    val typename: String
)