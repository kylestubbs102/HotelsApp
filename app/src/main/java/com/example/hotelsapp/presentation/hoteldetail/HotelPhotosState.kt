package com.example.hotelsapp.presentation.hoteldetail

import com.example.hotelsapp.domain.model.HotelPhoto

data class HotelPhotosState(
    val isLoading: Boolean = false,
    val hotelPhotoList: List<HotelPhoto> = emptyList(),
    val error: String = "",
)
