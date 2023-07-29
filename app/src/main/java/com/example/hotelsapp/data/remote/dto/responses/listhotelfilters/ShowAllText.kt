package com.example.hotelsapp.data.remote.dto.responses.listhotelfilters


import com.google.gson.annotations.SerializedName

data class ShowAllText(
    @SerializedName("debugValueKey")
    val debugValueKey: Any?,
    @SerializedName("string")
    val string: String,
    @SerializedName("__typename")
    val typename: String
)