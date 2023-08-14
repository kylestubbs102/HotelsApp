package com.example.hotelsapp.domain.model

data class HotelList(
    val hotelRows: List<HotelListRow>,
    val updateToken: String,
)
