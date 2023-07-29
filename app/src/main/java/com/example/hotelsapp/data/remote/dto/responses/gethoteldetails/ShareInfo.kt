package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class ShareInfo(
    @SerializedName("emailBody")
    val emailBody: EmailBody,
    @SerializedName("emailSubject")
    val emailSubject: EmailSubject,
    @SerializedName("nonEmailMessage")
    val nonEmailMessage: NonEmailMessage,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("webUrl")
    val webUrl: String
)