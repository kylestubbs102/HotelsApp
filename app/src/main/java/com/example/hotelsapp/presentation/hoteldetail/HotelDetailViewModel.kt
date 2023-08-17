package com.example.hotelsapp.presentation.hoteldetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotelsapp.domain.usecase.FetchAndCacheHotelDetailsUseCase
import com.example.hotelsapp.domain.usecase.GetCachedHotelPhotosUseCase
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
    private val fetchAndCacheHotelDetailsUseCase: FetchAndCacheHotelDetailsUseCase,
    private val getCachedHotelPhotosUseCase: GetCachedHotelPhotosUseCase,
) : ViewModel() {

    private val contentId: String = checkNotNull(savedStateHandle[CONTENT_ID])

    private val hotelDetailsMutableState = MutableStateFlow(HotelDetailState())

    val hotelDetailState: StateFlow<HotelDetailState>
        get() = hotelDetailsMutableState

    fun getHotelDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            // Fetch and cache data. If successful, then
            // fetch the components individually
            fetchAndCacheHotelDetailsUseCase(contentId)
                .collect {
                    when (it) {
                        is Resource.Loading -> {
                            hotelDetailsMutableState.value = HotelDetailState(isLoading = true)
                        }
                        is Resource.Error -> {
                            hotelDetailsMutableState.value = hotelDetailsMutableState.value.copy(
                                error = it.message ?: "No error message present"
                            )
                        }
                        is Resource.Success -> {
                            fetchUIComponentsIndividually()
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
                            // No-op
                        }
                        is Resource.Error -> {
                            hotelDetailsMutableState.value = hotelDetailsMutableState.value.copy(
                                error = it.message ?: "No error message present"
                            )
                        }
                        is Resource.Success -> {
                            hotelDetailsMutableState.value = hotelDetailsMutableState.value.copy(
                                isLoading = false, // remove later,
                                hotelPhotoList = it.data ?: emptyList()
                            )
                            // TODO : Check if all jobs are done and remove isLoading. Only
                            //  needed when more jobs are added
                        }
                    }
                }
        }
    }
}
