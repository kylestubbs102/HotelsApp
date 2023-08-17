package com.example.hotelsapp.domain.repository

import com.example.hotelsapp.domain.model.HotelPhoto

interface HotelDetailsRepository {

    suspend fun fetchAndCacheHotelDetails(contentId: String)

    suspend fun getHotelPhotosFromDatabase(contentId: String): List<HotelPhoto>
}
