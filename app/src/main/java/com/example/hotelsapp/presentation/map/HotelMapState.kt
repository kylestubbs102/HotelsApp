package com.example.hotelsapp.presentation.map

import com.example.hotelsapp.domain.model.HotelRow

data class HotelMapState(
    val isLoading: Boolean = false,
    val hotelRowList: List<HotelRow> = emptyList(),
    val error: String = "",
)
