package com.example.hotelsapp.data.remote.dto.responses.listnearby


import com.google.gson.annotations.SerializedName

data class Commerce(
    @SerializedName("attractionCommerce")
    val attractionCommerce: AttractionCommerce,
    @SerializedName("hotelCommerce")
    val hotelCommerce: HotelCommerce,
    @SerializedName("lastUpdated")
    val lastUpdated: Any?,
    @SerializedName("restaurantCommerce")
    val restaurantCommerce: RestaurantCommerce,
    @SerializedName("__typename")
    val typename: String
)