package com.example.hotelsapp.presentation.hoteldetail

import com.example.hotelsapp.domain.model.HotelReviewRow

data class HotelReviewsState(
    val isLoading: Boolean = false,
    val hotelReviews: List<HotelReviewRow> = emptyList(),
    val error: String = "",
)
