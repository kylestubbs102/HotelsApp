package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class RestaurantCommerce(
    @SerializedName("partySize")
    val partySize: Int,
    @SerializedName("reservationTime")
    val reservationTime: String,
    @SerializedName("setByUser")
    val setByUser: Boolean,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("updated")
    val updated: Any?
)