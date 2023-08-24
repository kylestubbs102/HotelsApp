package com.example.hotelsapp.domain.usecase

import com.example.hotelsapp.domain.model.HotelReviewRow
import com.example.hotelsapp.domain.repository.HotelDetailsRepository
import com.example.hotelsapp.util.Resource
import java.util.concurrent.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCachedHotelReviewsUseCase(
    private val hotelDetailsRepository: HotelDetailsRepository
) {

    operator fun invoke(contentId: String): Flow<Resource<List<HotelReviewRow>>> =
        flow {
            try {
                emit(Resource.Loading())
                val reviews = hotelDetailsRepository.getHotelReviewsFromCache(contentId)
                emit(Resource.Success(reviews))
            } catch (e: Exception) {
                // rethrow to prevent zombie state
                if (e is CancellationException || e is InterruptedException) {
                    throw e;
                }
                emit(Resource.Error("Failed to get cached hotel photos"))
            }
        }
}
