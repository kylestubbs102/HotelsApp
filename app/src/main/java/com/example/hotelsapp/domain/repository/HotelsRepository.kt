package com.example.hotelsapp.domain.repository

import com.example.hotelsapp.domain.model.LocationQueryRow

interface HotelsRepository {

    suspend fun searchHotels(query: String): List<LocationQueryRow>
}
