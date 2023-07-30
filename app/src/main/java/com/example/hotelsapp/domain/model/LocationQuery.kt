package com.example.hotelsapp.domain.model

data class LocationQuery(
    val query: String,
    val hotelQueryList: List<LocationQueryRow>,
)
