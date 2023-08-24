package com.example.hotelsapp.domain.repository

import com.example.hotelsapp.domain.model.HotelDetails
import com.example.hotelsapp.domain.model.HotelPhoto
import com.example.hotelsapp.domain.model.HotelReviewRow

interface HotelDetailsRepository {

    suspend fun fetchAndCacheHotelDetails(contentId: String)

    suspend fun getHotelPhotosFromCache(contentId: String): List<HotelPhoto>

    suspend fun getHotelDetailsFromCache(contentId: String): HotelDetails

    suspend fun getHotelReviewsFromCache(contentId: String): List<HotelReviewRow>
}
