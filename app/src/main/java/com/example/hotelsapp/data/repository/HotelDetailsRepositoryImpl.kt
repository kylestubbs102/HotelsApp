package com.example.hotelsapp.data.repository

import com.example.hotelsapp.data.local.HotelsDao
import com.example.hotelsapp.data.local.mapper.toHotelDetails
import com.example.hotelsapp.data.local.mapper.toHotelDetailsEntity
import com.example.hotelsapp.data.local.mapper.toHotelPhotoEntities
import com.example.hotelsapp.data.local.mapper.toHotelPhotoList
import com.example.hotelsapp.data.local.mapper.toHotelReviewEntities
import com.example.hotelsapp.data.local.mapper.toHotelReviewRow
import com.example.hotelsapp.data.remote.HotelsCalls
import com.example.hotelsapp.data.remote.dto.requests.gethoteldetails.GetHotelDetailsRequest
import com.example.hotelsapp.domain.model.HotelDetails
import com.example.hotelsapp.domain.model.HotelPhoto
import com.example.hotelsapp.domain.model.HotelReviewRow
import com.example.hotelsapp.domain.repository.HotelDetailsRepository

class HotelDetailsRepositoryImpl(
    private val hotelsDao: HotelsDao,
    private val apiCalls: HotelsCalls,
) : HotelDetailsRepository {

    override suspend fun fetchAndCacheHotelDetails(contentId: String) {
        if (hotelsDao.doesHotelPhotoListExist(contentId)
            && hotelsDao.doHotelDetailsExist(contentId)
            && hotelsDao.doesHotelReviewListExist(contentId)
        ) {
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
        val hotelDetailEntity = response.toHotelDetailsEntity(contentId)
        val hotelReviewEntities = response.toHotelReviewEntities(contentId)

        hotelsDao.insertHotelPhotoList(hotelPhotoEntities)
        hotelsDao.insertHotelDetails(hotelDetailEntity)
        hotelsDao.insertHotelReviewList(hotelReviewEntities)
    }

    override suspend fun getHotelPhotosFromCache(contentId: String): List<HotelPhoto> {
        return hotelsDao
            .getHotelPhotoList(contentId)
            .toHotelPhotoList()
    }

    override suspend fun getHotelDetailsFromCache(contentId: String): HotelDetails {
        return hotelsDao
            .getHotelDetails(contentId)
            .toHotelDetails()
    }

    override suspend fun getHotelReviewsFromCache(contentId: String): List<HotelReviewRow> {
        return hotelsDao
            .getHotelReviewList(contentId)
            .map { it.toHotelReviewRow() }
    }


}
