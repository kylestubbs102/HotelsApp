package com.example.hotelsapp.data.remote.dto.responses.search


import com.google.gson.annotations.SerializedName

data class ListTitle(
    @SerializedName("debugValueKey")
    val debugValueKey: Any?,
    @SerializedName("string")
    val string: String,
    @SerializedName("__typename")
    val typename: String
)