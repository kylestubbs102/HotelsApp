package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("address")
    val address: String,
    @SerializedName("geoPoint")
    val geoPoint: GeoPoint,
    @SerializedName("__typename")
    val typename: String
)