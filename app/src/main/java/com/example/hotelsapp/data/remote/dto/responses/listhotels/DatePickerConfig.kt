package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class DatePickerConfig(
    @SerializedName("attractionProductDatePickerConfig")
    val attractionProductDatePickerConfig: Any?,
    @SerializedName("hotelDatePickerConfig")
    val hotelDatePickerConfig: HotelDatePickerConfig,
    @SerializedName("lastSelectableDate")
    val lastSelectableDate: String,
    @SerializedName("restaurantDatePickerConfig")
    val restaurantDatePickerConfig: RestaurantDatePickerConfig,
    @SerializedName("surfaces")
    val surfaces: List<String>,
    @SerializedName("timeZoneOffset")
    val timeZoneOffset: String,
    @SerializedName("__typename")
    val typename: String
)