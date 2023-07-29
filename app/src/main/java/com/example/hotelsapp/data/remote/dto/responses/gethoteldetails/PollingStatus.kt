package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class PollingStatus(
    @SerializedName("delayForNextPollInMillis")
    val delayForNextPollInMillis: Int,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("updateToken")
    val updateToken: String
)