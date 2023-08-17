package com.example.hotelsapp.domain.model

data class HotelPhoto(
    val caption: String,
    val thumbsUpVotes: Int,
    val publishedDateTime: String,
    val uploadDateTime: String,
    val urlTemplate: String,
    val maxHeight: Int,
    val maxWidth: Int,
)
