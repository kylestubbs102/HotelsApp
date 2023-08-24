package com.example.hotelsapp.domain.model

data class HotelRow(
    val hotel: String,
    val contentId: Int,
    val geoId: Int,
    val latitude: Double,
    val longitude: Double,
    val updateToken: String,
    val rating: Double? = null,
    val numberOfReviews: String? = null,
    val photoUrl: String? = null,
) {

    /**
     * Check if the values are a valid response from the service
     */
    fun isValid(): Boolean = hotel.isNotBlank() && contentId > 0
}
