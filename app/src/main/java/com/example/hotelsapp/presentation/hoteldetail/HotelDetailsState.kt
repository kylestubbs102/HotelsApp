package com.example.hotelsapp.presentation.hoteldetail

import com.example.hotelsapp.domain.model.HotelDetails
import com.example.hotelsapp.domain.model.LocationQueryRow

data class HotelDetailsState(
    val isLoading: Boolean = false,
    val hotelDetails: HotelDetails? = null,
    val locationQueryRow: LocationQueryRow? = null,
    val error: String = "",
)
