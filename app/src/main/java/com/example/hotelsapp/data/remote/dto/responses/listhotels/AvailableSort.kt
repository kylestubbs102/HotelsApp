package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class AvailableSort(
    @SerializedName("isAscending")
    val isAscending: Boolean,
    @SerializedName("isSelected")
    val isSelected: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("surfaces")
    val surfaces: List<String>,
    @SerializedName("title")
    val title: Title,
    @SerializedName("tooltipV2")
    val tooltipV2: Any?,
    @SerializedName("trackingKey")
    val trackingKey: String,
    @SerializedName("trackingTitle")
    val trackingTitle: String,
    @SerializedName("__typename")
    val typename: String
)