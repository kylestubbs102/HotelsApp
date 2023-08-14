package com.example.hotelsapp.presentation.home

import com.example.hotelsapp.domain.model.HotelListRow

data class HomeHotelListState(
    val isLoading: Boolean = false,
    val hotelRows: List<HotelListRow> = emptyList(),
    val error: String = "",
)
