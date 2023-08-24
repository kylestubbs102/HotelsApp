package com.example.hotelsapp.domain.usecase

import com.example.hotelsapp.data.local.HotelsDao
import com.example.hotelsapp.data.local.mapper.toLocationQueryRow
import com.example.hotelsapp.domain.model.LocationQueryRow
import com.example.hotelsapp.util.Resource
import java.util.concurrent.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetLocationQueryUseCase(
    private val hotelsDao: HotelsDao
) {

    operator fun invoke(geoId: Int): Flow<Resource<LocationQueryRow>> =
        flow {
            try {
                emit(Resource.Loading())
                val locationQueryEntity = hotelsDao.getLocationQueryFromGeoId(geoId)
                emit(Resource.Success(locationQueryEntity.toLocationQueryRow()))
            } catch (e: Exception) {
                // rethrow to prevent zombie state
                if (e is CancellationException || e is InterruptedException) {
                    throw e;
                }
                emit(Resource.Error("Failed to get cached hotel photos"))
            }
        }
}
