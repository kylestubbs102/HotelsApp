package com.example.hotelsapp.data.repository

import com.example.hotelsapp.data.local.HotelsDao
import com.example.hotelsapp.data.local.mapper.toHotelPhotoEntities
import com.example.hotelsapp.data.local.mapper.toHotelPhotoList
import com.example.hotelsapp.data.remote.HotelsCalls
import com.example.hotelsapp.data.remote.dto.requests.gethoteldetails.GetHotelDetailsRequest
import com.example.hotelsapp.domain.model.HotelPhoto
import com.example.hotelsapp.domain.repository.HotelDetailsRepository

class HotelDetailsRepositoryImpl(
    private val hotelsDao: HotelsDao,
    private val apiCalls: HotelsCalls,
) : HotelDetailsRepository {

    override suspend fun fetchAndCacheHotelDetails(contentId: String) {
        if (hotelsDao.doesHotelPhotoListExist(contentId)) {
            return
        }

        val request = GetHotelDetailsRequest(
            contentId = contentId,
            checkIn = "2022-03-18",
            checkOut = "2022-03-19",
            rooms = emptyList(),
        )
        val response = apiCalls.getHotelDetails(request)

        val hotelPhotoEntities = response.toHotelPhotoEntities(contentId)

        hotelsDao.insertHotelPhotoList(hotelPhotoEntities)
    }

    override suspend fun getHotelPhotosFromDatabase(contentId: String): List<HotelPhoto> {
        return hotelsDao
            .getHotelPhotoList(contentId)
            .toHotelPhotoList()
    }
}
