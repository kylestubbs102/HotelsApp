package com.example.hotelsapp.data.remote.dto.responses.gethoteloffers


import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("dialog")
    val dialog: Dialog,
    @SerializedName("text")
    val text: Text,
    @SerializedName("trackingContext")
    val trackingContext: String,
    @SerializedName("__typename")
    val typename: String
)