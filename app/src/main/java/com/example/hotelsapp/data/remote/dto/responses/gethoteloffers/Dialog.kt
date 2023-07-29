package com.example.hotelsapp.data.remote.dto.responses.gethoteloffers


import com.google.gson.annotations.SerializedName

data class Dialog(
    @SerializedName("content")
    val content: Content,
    @SerializedName("dialogType")
    val dialogType: String,
    @SerializedName("title")
    val title: Title,
    @SerializedName("__typename")
    val typename: String
)