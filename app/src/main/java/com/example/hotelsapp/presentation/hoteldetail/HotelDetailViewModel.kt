package com.example.hotelsapp.presentation.hoteldetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotelsapp.domain.usecase.FetchAndCacheHotelDetailsUseCase
import com.example.hotelsapp.domain.usecase.GetCachedHotelDetailsUseCase
import com.example.hotelsapp.domain.usecase.GetCachedHotelPhotosUseCase
import com.example.hotelsapp.domain.usecase.GetCachedHotelReviewsUseCase
import com.example.hotelsapp.domain.usecase.GetHotelRowInfoUseCase
import com.example.hotelsapp.domain.usecase.GetLocationQueryUseCase
import com.example.hotelsapp.presentation.navigation.CONTENT_ID
import com.example.hotelsapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HotelDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getHotelRowInfoUseCase: GetHotelRowInfoUseCase,
    private val getLocationQueryUseCase: GetLocationQueryUseCase,
    private val fetchAndCacheHotelDetailsUseCase: FetchAndCacheHotelDetailsUseCase,
    private val getCachedHotelPhotosUseCase: GetCachedHotelPhotosUseCase,
    private val getCachedHotelDetailsUseCase: GetCachedHotelDetailsUseCase,
    private val getCachedHotelReviewsUseCase: GetCachedHotelReviewsUseCase,
) : ViewModel() {

    val contentId: String = checkNotNull(savedStateHandle[CONTENT_ID])

    private val hotelPhotosMutableState = MutableStateFlow(HotelPhotosState(isLoading = true))

    val hotelPhotosState: StateFlow<HotelPhotosState>
        get() = hotelPhotosMutableState

    private val hotelRowMutableState = MutableStateFlow(HotelRowState(isLoading = true))

    val hotelRowState: StateFlow<HotelRowState>
        get() = hotelRowMutableState

    private val hotelDetailMutableState = MutableStateFlow(HotelDetailsState(isLoading = true))

    val hotelDetailState: StateFlow<HotelDetailsState>
        get() = hotelDetailMutableState

    private val hotelReviewMutableState = MutableStateFlow(HotelReviewsState(isLoading = true))

    val hotelReviewState: StateFlow<HotelReviewsState>
        get() = hotelReviewMutableState

    fun getHotelDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            // Fetch and cache data. If successful, then
            // fetch the components individually
            fetchAndCacheHotelDetailsUseCase(contentId)
                .collect {
                    when (it) {
                        is Resource.Loading -> {
                            // no-op
                        }
                        is Resource.Error -> {
                            // TODO : set all to error
                        }
                        is Resource.Success -> {
                            fetchUIComponentsIndividually()
                        }
                    }
                }

            getHotelRowInfoUseCase(contentId)
                .collect {
                    when (it) {
                        is Resource.Loading -> {
                            hotelRowMutableState.value = HotelRowState(isLoading = true)
                        }
                        is Resource.Error -> {
                            hotelRowMutableState.value = HotelRowState(
                                error = it.message ?: "No error message present"
                            )
                        }
                        is Resource.Success -> {
                            hotelRowMutableState.value = HotelRowState(hotelRow = it.data)
                            getCachedLocationInfo(it.data?.geoId)
                        }
                    }
                }
        }
    }

    private suspend fun fetchUIComponentsIndividually() {
        viewModelScope.launch(Dispatchers.IO) {
            getCachedHotelPhotosUseCase(contentId)
                .collect {
                    when (it) {
                        is Resource.Loading -> {
                            hotelPhotosMutableState.value = HotelPhotosState(isLoading = true)
                        }
                        is Resource.Error -> {
                            hotelPhotosMutableState.value = HotelPhotosState(
                                error = it.message ?: "No error message present"
                            )
                        }
                        is Resource.Success -> {
                            hotelPhotosMutableState.value = HotelPhotosState(
                                hotelPhotoList = it.data ?: emptyList()
                            )
                        }
                    }
                }

            getCachedHotelDetailsUseCase(contentId)
                .collect {
                    when (it) {
                        is Resource.Loading -> {
                            hotelDetailMutableState.value = hotelDetailMutableState.value.copy(
                                isLoading = true
                            )
                        }
                        is Resource.Error -> {
                            hotelDetailMutableState.value = hotelDetailMutableState.value.copy(
                                error = it.message ?: "No error message present"
                            )
                        }
                        is Resource.Success -> {
                            hotelDetailMutableState.value = hotelDetailMutableState.value.copy(
                                isLoading = false,
                                hotelDetails = it.data
                            )
                        }
                    }
                }

            getCachedHotelReviewsUseCase(contentId)
                .collect {
                    when (it) {
                        is Resource.Loading -> {
                            hotelReviewMutableState.value = HotelReviewsState(isLoading = true)
                        }
                        is Resource.Error -> {
                            hotelReviewMutableState.value = HotelReviewsState(
                                error = it.message ?: "No error message present"
                            )
                        }
                        is Resource.Success -> {
                            hotelReviewMutableState.value = HotelReviewsState(
                                hotelReviews = it.data ?: emptyList()
                            )
                        }
                    }
                }
        }
    }

    private suspend fun getCachedLocationInfo(geoId: Int?) {
        if (geoId == null) {
            hotelDetailMutableState.value = hotelDetailMutableState.value.copy(
                error = "Not valid geoId provided"
            )
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            getLocationQueryUseCase(geoId)
                .collect {
                    when (it) {
                        is Resource.Loading -> {
                            hotelDetailMutableState.value = hotelDetailMutableState.value.copy(
                                isLoading = true
                            )
                        }
                        is Resource.Error -> {
                            hotelDetailMutableState.value = hotelDetailMutableState.value.copy(
                                error = it.message ?: "No error message present"
                            )
                        }
                        is Resource.Success -> {
                            hotelDetailMutableState.value = hotelDetailMutableState.value.copy(
                                isLoading = false,
                                locationQueryRow = it.data
                            )
                        }
                    }
                }
        }
    }
}
