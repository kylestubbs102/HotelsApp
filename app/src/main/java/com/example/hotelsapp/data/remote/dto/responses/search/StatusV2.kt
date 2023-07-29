package com.example.hotelsapp.data.remote.dto.responses.search


import com.google.gson.annotations.SerializedName

data class StatusV2(
    @SerializedName("partial")
    val partial: Boolean,
    @SerializedName("pollingStatus")
    val pollingStatus: Any?,
    @SerializedName("__typename")
    val typename: String
)