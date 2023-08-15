package com.example.hotelsapp.presentation.home

import com.example.hotelsapp.domain.model.HotelRow

data class HomeHotelListState(
    val isLoading: Boolean = false,
    val hotelRows: List<HotelRow> = emptyList(),
    val error: String = "",
)
