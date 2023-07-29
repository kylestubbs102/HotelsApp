package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class NullableTitle(
    @SerializedName("debugValueKey")
    val debugValueKey: Any?,
    @SerializedName("string")
    val string: String,
    @SerializedName("__typename")
    val typename: String
)