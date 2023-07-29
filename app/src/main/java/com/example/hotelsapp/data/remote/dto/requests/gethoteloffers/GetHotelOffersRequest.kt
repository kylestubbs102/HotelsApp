package com.example.hotelsapp.data.remote.dto.requests.gethoteloffers


import com.google.gson.annotations.SerializedName

data class GetHotelOffersRequest(
    @SerializedName("checkIn")
    val checkIn: String,
    @SerializedName("checkOut")
    val checkOut: String,
    @SerializedName("detailId")
    val detailId: Int,
    @SerializedName("rooms")
    val rooms: List<Room>,
    @SerializedName("updateToken")
    val updateToken: String? = null,
)