package com.example.hotelsapp.data.remote.dto.responses.listnearby


import com.google.gson.annotations.SerializedName

data class HotelCommerce(
    @SerializedName("checkIn")
    val checkIn: String,
    @SerializedName("checkOut")
    val checkOut: String,
    @SerializedName("rooms")
    val rooms: List<Room>,
    @SerializedName("setByUser")
    val setByUser: Boolean,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("updated")
    val updated: Any?
)