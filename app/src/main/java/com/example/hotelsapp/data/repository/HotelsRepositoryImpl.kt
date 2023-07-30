package com.example.hotelsapp.data.repository

import com.example.hotelsapp.data.local.HotelsDao
import com.example.hotelsapp.data.local.mapper.toLocationQueryEntity
import com.example.hotelsapp.data.remote.HotelsCalls
import com.example.hotelsapp.data.remote.dto.requests.search.SearchLocationsRequest
import com.example.hotelsapp.domain.model.LocationQueryRow
import com.example.hotelsapp.domain.repository.HotelsRepository

class HotelsRepositoryImpl(
    private val dao: HotelsDao,
    private val apiCalls: HotelsCalls
) : HotelsRepository {

    override suspend fun searchHotels(query: String): List<LocationQueryRow> {
        // query db and check if present
        if (dao.doesQueryExist(query)) {
            return dao.getLocationQuery(query).hotelQueryList
        }

        // Fetch from server
        val searchLocationsRequest = SearchLocationsRequest(query)
        val searchLocationsResponse = apiCalls.searchLocations(searchLocationsRequest)

        // Map to db entity
        val entity = searchLocationsResponse.toLocationQueryEntity(query)

        // put and return from db
        dao.insertLocationQuery(entity)
        return dao.getLocationQuery(query).hotelQueryList
    }
}
