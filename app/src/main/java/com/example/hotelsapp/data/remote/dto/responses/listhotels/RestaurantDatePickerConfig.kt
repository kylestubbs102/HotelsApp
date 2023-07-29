package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class RestaurantDatePickerConfig(
    @SerializedName("numDisplayOptions")
    val numDisplayOptions: Int,
    @SerializedName("reservationRange")
    val reservationRange: ReservationRange,
    @SerializedName("__typename")
    val typename: String
)