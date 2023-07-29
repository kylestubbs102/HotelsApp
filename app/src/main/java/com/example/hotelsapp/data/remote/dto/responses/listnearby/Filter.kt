package com.example.hotelsapp.data.remote.dto.responses.listnearby


import com.google.gson.annotations.SerializedName

data class Filter(
    @SerializedName("name")
    val name: String,
    @SerializedName("surfaces")
    val surfaces: List<String>,
    @SerializedName("title")
    val title: String,
    @SerializedName("tooltip")
    val tooltip: Any?,
    @SerializedName("trackingKey")
    val trackingKey: String,
    @SerializedName("trackingTitle")
    val trackingTitle: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("values")
    val values: List<Value>
)