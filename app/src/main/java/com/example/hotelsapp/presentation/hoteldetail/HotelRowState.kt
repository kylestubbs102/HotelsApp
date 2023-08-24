package com.example.hotelsapp.presentation.hoteldetail

import com.example.hotelsapp.domain.model.HotelRow

data class HotelRowState(
    val isLoading: Boolean = false,
    val hotelRow: HotelRow? = null,
    val error: String = "",
)
