package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class StatusV2(
    @SerializedName("partial")
    val partial: Boolean,
    @SerializedName("pollingStatus")
    val pollingStatus: PollingStatus?,
    @SerializedName("__typename")
    val typename: String
)