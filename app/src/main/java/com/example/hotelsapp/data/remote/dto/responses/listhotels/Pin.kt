package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class Pin(
    @SerializedName("fallbackIcon")
    val fallbackIcon: String,
    @SerializedName("geoPoint")
    val geoPoint: GeoPoint,
    @SerializedName("icon")
    val icon: Icon,
    @SerializedName("isSaved")
    val isSaved: Boolean,
    @SerializedName("saveId")
    val saveId: SaveId,
    @SerializedName("trackingKey")
    val trackingKey: String,
    @SerializedName("trackingTitle")
    val trackingTitle: String,
    @SerializedName("__typename")
    val typename: String
)