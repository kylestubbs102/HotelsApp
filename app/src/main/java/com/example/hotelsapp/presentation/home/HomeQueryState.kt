package com.example.hotelsapp.presentation.home

import com.example.hotelsapp.domain.model.LocationQueryRow

data class HomeQueryState(
    val isLoading: Boolean = false,
    val queryRows: List<LocationQueryRow> = emptyList(),
    val error: String = "",
)
