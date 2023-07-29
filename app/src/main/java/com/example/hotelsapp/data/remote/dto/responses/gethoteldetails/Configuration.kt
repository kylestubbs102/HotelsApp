package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class Configuration(
    @SerializedName("configType")
    val configType: String,
    @SerializedName("maxAdultsPerRoom")
    val maxAdultsPerRoom: Int,
    @SerializedName("maxChildrenPerRoom")
    val maxChildrenPerRoom: Int,
    @SerializedName("maxRooms")
    val maxRooms: Int,
    @SerializedName("maxStayLength")
    val maxStayLength: Int,
    @SerializedName("priceHeatmap")
    val priceHeatmap: Any?,
    @SerializedName("__typename")
    val typename: String
)