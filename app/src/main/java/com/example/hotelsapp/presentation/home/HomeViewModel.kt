package com.example.hotelsapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotelsapp.domain.repository.HotelsRepository
import com.example.hotelsapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val hotelsRepository: HotelsRepository,
) : ViewModel() {

    private val queryMutableState = MutableStateFlow(HomeQueryState())

    val queryState: StateFlow<HomeQueryState>
        get() = queryMutableState

    private val hotelListMutableState = MutableStateFlow(HomeHotelListState())

    val hotelListState: StateFlow<HomeHotelListState>
        get() = hotelListMutableState

    private var queryJob: Job? = null
    private var searchHotelsListJob: Job? = null

    private var updateToken: String = ""

    fun queryLocation(query: String) {
        queryJob?.cancel()
        queryJob = viewModelScope.launch(Dispatchers.IO) {
            if (canPerformSearch(query).not()) {
                return@launch
            }

            delay(QUERY_DELAY)
            hotelsRepository
                .searchHotels(query)
                .collectLatest {
                    when (it) {
                        is Resource.Loading -> {
                            queryMutableState.value = HomeQueryState(
                                isLoading = true,
                            )
                        }
                        is Resource.Success -> {
                            queryMutableState.value = HomeQueryState(
                                queryRows = it.data?.take(QUERY_RESULT_LENGTH) ?: emptyList(),
                            )
                        }
                        is Resource.Error -> {
                            queryMutableState.value = HomeQueryState(
                                error = it.message ?: "An unexpected error occurred"
                            )
                        }
                    }
                }
        }
    }

    fun searchHotelsList(
        geoId: Int,
        isInitialFetch: Boolean
    ) {
        searchHotelsListJob?.cancel()
        searchHotelsListJob = viewModelScope.launch(Dispatchers.IO) {
            hotelsRepository
                .getHotelsList(geoId, updateToken, isInitialFetch)
                .collectLatest {
                    when (it) {
                        is Resource.Loading -> {
                            hotelListMutableState.value = HomeHotelListState(
                                isLoading = true,
                            )
                        }
                        is Resource.Success -> {
                            hotelListMutableState.value = HomeHotelListState(
                                hotelRows = it.data ?: emptyList(),
                            )
                            // Fetch update token from last item to page for next items
                            updateToken = it.data?.last()?.updateToken ?: ""
                        }
                        is Resource.Error -> {
                            hotelListMutableState.value = HomeHotelListState(
                                error = it.message ?: "An unexpected error occurred"
                            )
                        }
                    }
                }
        }
    }

    fun clearQuery() = run {
        queryMutableState.value = HomeQueryState()
    }

    private fun canPerformSearch(query: String): Boolean = query.length >= MIN_QUERY_LENGTH

    companion object {
        private const val MIN_QUERY_LENGTH = 3
        private const val QUERY_RESULT_LENGTH = 7
        private const val QUERY_DELAY = 500L
    }
}
