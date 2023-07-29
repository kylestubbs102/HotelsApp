package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class ExcellentBar(
    @SerializedName("count")
    val count: Count,
    @SerializedName("isSelected")
    val isSelected: Boolean,
    @SerializedName("label")
    val label: Label,
    @SerializedName("percentage")
    val percentage: Int,
    @SerializedName("__typename")
    val typename: String
)