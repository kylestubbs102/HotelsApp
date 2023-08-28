package com.example.hotelsapp.presentation.home

import com.example.hotelsapp.domain.model.LocationQueryRow

data class HomeQueryState(
    val isLoading: Boolean = false,
    val querySelection: LocationQueryRow? = null,
    val dates: Pair<String, String> = Pair("", ""),
    val queryRows: List<LocationQueryRow> = emptyList(),
    val error: String = "",
)
