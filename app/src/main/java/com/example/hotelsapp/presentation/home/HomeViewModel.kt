package com.example.hotelsapp.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotelsapp.domain.repository.HotelsRepository
import com.example.hotelsapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val hotelsRepository: HotelsRepository,
) : ViewModel() {

    private val queryMutableState = mutableStateOf(HomeQueryState())

    val queryState: State<HomeQueryState>
        get() = queryMutableState

    private val hotelListMutableState = mutableStateOf(HomeHotelListState())

    val hotelListState: State<HomeHotelListState>
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

    fun searchHotelsList(geoId: Int) {
        searchHotelsListJob?.cancel()
        searchHotelsListJob = viewModelScope.launch(Dispatchers.IO) {
            hotelsRepository
                .getHotelsList(geoId, updateToken)
                .collectLatest {
                    when (it) {
                        is Resource.Loading -> {
                            hotelListMutableState.value = HomeHotelListState(
                                isLoading = true,
                            )
                        }
                        is Resource.Success -> {
                            hotelListMutableState.value = HomeHotelListState(
                                hotelRows = it.data?.hotelRows ?: emptyList(),
                            )
                            updateToken = it.data?.updateToken ?: ""
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
