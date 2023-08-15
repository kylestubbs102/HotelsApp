package com.example.hotelsapp.domain.repository

import com.example.hotelsapp.domain.model.HotelRow
import com.example.hotelsapp.domain.model.LocationQueryRow
import com.example.hotelsapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface HotelsRepository {

    suspend fun searchHotels(query: String): Flow<Resource<List<LocationQueryRow>>>
    suspend fun getHotelsList(
        geoId: Int,
        updateToken: String,
        isInitialFetch: Boolean
    ): Flow<Resource<List<HotelRow>>>
}
