package com.example.hotelsapp.data.remote.dto.responses.gethoteloffers


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("AppPresentation_queryHotelCommerceV2")
    val appPresentationQueryHotelCommerceV2: AppPresentationQueryHotelCommerceV2
)