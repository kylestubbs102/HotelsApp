package com.example.hotelsapp.data.remote.dto.requests.gethoteldetails


import com.google.gson.annotations.SerializedName

data class GetHotelDetailsRequest(
    @SerializedName("checkIn")
    val checkIn: String,
    @SerializedName("checkOut")
    val checkOut: String,
    @SerializedName("contentId")
    val contentId: String,
    @SerializedName("rooms")
    val rooms: List<Room>,
    @SerializedName("updateToken")
    val updateToken: String? = null,
)