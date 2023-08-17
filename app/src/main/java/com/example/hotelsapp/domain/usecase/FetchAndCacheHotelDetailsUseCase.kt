package com.example.hotelsapp.domain.usecase

import com.example.hotelsapp.domain.repository.HotelDetailsRepository
import com.example.hotelsapp.util.Resource
import java.util.concurrent.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FetchAndCacheHotelDetailsUseCase(
    private val hotelDetailsRepository: HotelDetailsRepository
) {

    operator fun invoke(contentId: String): Flow<Resource<Unit>> =
        flow {
            try {
                emit(Resource.Loading())
                hotelDetailsRepository.fetchAndCacheHotelDetails(contentId)
                emit(Resource.Success(Unit))
            } catch (e: Exception) {
                // rethrow to prevent zombie state
                if (e is CancellationException || e is InterruptedException) {
                    throw e;
                }
                emit(Resource.Error("Failed to fetch and cache hotel details"))
            }
        }
}
