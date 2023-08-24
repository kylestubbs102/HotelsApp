package com.example.hotelsapp.domain.usecase

import com.example.hotelsapp.data.local.HotelsDao
import com.example.hotelsapp.data.local.mapper.toHotelRow
import com.example.hotelsapp.data.local.mapper.toHotelRowList
import com.example.hotelsapp.domain.model.HotelRow
import com.example.hotelsapp.util.Resource
import java.util.concurrent.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetHotelRowInfoUseCase(
    private val hotelsDao: HotelsDao
) {

    operator fun invoke(geoId: Int): Flow<Resource<List<HotelRow>>> =
        flow {
            try {
                emit(Resource.Loading())
                val hotelRowEntities = hotelsDao.getHotelRowList(geoId)
                emit(Resource.Success(hotelRowEntities.toHotelRowList()))
            } catch (e: Exception) {
                // rethrow to prevent zombie state
                if (e is CancellationException || e is InterruptedException) {
                    throw e;
                }
                emit(Resource.Error("Failed to get cached hotel photos"))
            }
        }

    operator fun invoke(contentId: String): Flow<Resource<HotelRow>> =
        flow {
            try {
                emit(Resource.Loading())
                val hotelRowEntity = hotelsDao.getHotelRowFromContentId(contentId)
                emit(Resource.Success(hotelRowEntity.toHotelRow()))
            } catch (e: Exception) {
                // rethrow to prevent zombie state
                if (e is CancellationException || e is InterruptedException) {
                    throw e;
                }
                emit(Resource.Error("Failed to get cached hotel photos"))
            }
        }
}
