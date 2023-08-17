package com.example.hotelsapp.domain.usecase

import com.example.hotelsapp.domain.model.HotelPhoto
import com.example.hotelsapp.domain.repository.HotelDetailsRepository
import com.example.hotelsapp.util.Resource
import java.util.concurrent.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCachedHotelPhotosUseCase(
    private val hotelDetailsRepository: HotelDetailsRepository
) {

    operator fun invoke(contentId: String): Flow<Resource<List<HotelPhoto>>> =
        flow {
            try {
                emit(Resource.Loading())
                val photos = hotelDetailsRepository.getHotelPhotosFromDatabase(contentId)
                emit(Resource.Success(photos))
            } catch (e: Exception) {
                // rethrow to prevent zombie state
                if (e is CancellationException || e is InterruptedException) {
                    throw e;
                }
                emit(Resource.Error("Failed to get cached hotel photos"))
            }
        }
}
