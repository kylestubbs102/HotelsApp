package com.example.hotelsapp.domain.model

data class LocationQueryRow(
    val geoId: Int,
    val location: String,
    val city: String,
) {

    /**
     * Check if the values are a valid response from the service
     */
    fun isValid(): Boolean = location.isNotBlank() && city.isNotBlank() && geoId > 0

    override fun toString(): String {
        return "$location, $city"
    }
}
