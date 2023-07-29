package com.example.hotelsapp.data.remote.dto.responses.gethoteloffers


import com.google.gson.annotations.SerializedName

data class Label(
    @SerializedName("icon")
    val icon: String,
    @SerializedName("link")
    val link: Link,
    @SerializedName("text")
    val text: Text,
    @SerializedName("__typename")
    val typename: String
)