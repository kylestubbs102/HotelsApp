package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class ReportAction(
    @SerializedName("authenticateUser")
    val authenticateUser: Boolean,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("webUrl")
    val webUrl: WebUrl
)