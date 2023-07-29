package com.example.hotelsapp.presentation.home

data class HomeState(
    val isLoading: Boolean = false,
    val hotels: List<String> = emptyList(),
    val error: String = ""
)
