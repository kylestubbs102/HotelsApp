package com.example.hotelsapp.presentation.map

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotelsapp.domain.model.HotelRow
import com.example.hotelsapp.domain.usecase.GetHotelRowInfoUseCase
import com.example.hotelsapp.presentation.navigation.CONTENT_ID
import com.example.hotelsapp.presentation.navigation.GEO_ID
import com.example.hotelsapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HotelMapViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getHotelRowInfoUseCase: GetHotelRowInfoUseCase
) : ViewModel() {

    // Only one of these will be valid
    val contentId: String? = savedStateHandle[CONTENT_ID]
    val geoId: String? = savedStateHandle[GEO_ID]

    private val hotelMapMutableState = MutableStateFlow(HotelMapState(isLoading = true))

    val hotelMapState: StateFlow<HotelMapState>
        get() = hotelMapMutableState

    init {
        // Might need to call in LaunchedEffect(Unit) in case this is lazy triggered
        getCoordinates()
    }

    private fun getCoordinates() {
        if (contentId != null) {
            fetchSingleHotelCoordinates(contentId)
        } else if (geoId != null) {
            fetchMultipleHotelCoordinates(geoId.toInt())
        } else {
            throw IllegalStateException("Can't have both geoId and contentId be null")
        }
    }

    private fun fetchSingleHotelCoordinates(contentId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getHotelRowInfoUseCase(contentId)
                .collect {
                    when (it) {
                        is Resource.Loading -> {
                            hotelMapMutableState.value = HotelMapState(isLoading = true)
                        }
                        is Resource.Error -> {
                            hotelMapMutableState.value =
                                HotelMapState(error = it.message ?: "No error message")
                        }
                        is Resource.Success -> {
                            hotelMapMutableState.value =
                                HotelMapState(hotelRowList = listOf(it.data as HotelRow))
                        }
                    }
                }
        }
    }

    private fun fetchMultipleHotelCoordinates(geoId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getHotelRowInfoUseCase(geoId)
                .collect {
                    when (it) {
                        is Resource.Loading -> {
                            hotelMapMutableState.value = HotelMapState(isLoading = true)
                        }
                        is Resource.Error -> {
                            hotelMapMutableState.value =
                                HotelMapState(error = it.message ?: "No error message")
                        }
                        is Resource.Success -> {
                            hotelMapMutableState.value =
                                HotelMapState(hotelRowList = it.data ?: emptyList())
                        }
                    }
                }
        }
    }
}