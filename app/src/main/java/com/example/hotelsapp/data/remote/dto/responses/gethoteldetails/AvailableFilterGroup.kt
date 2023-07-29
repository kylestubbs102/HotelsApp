package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class AvailableFilterGroup(
    @SerializedName("filter")
    val filter: Filter?,
    @SerializedName("filters")
    val filters: List<FilterX>?,
    @SerializedName("groupType")
    val groupType: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("tooltip")
    val tooltip: Any?,
    @SerializedName("trackingKey")
    val trackingKey: String,
    @SerializedName("trackingTitle")
    val trackingTitle: String,
    @SerializedName("__typename")
    val typename: String
)