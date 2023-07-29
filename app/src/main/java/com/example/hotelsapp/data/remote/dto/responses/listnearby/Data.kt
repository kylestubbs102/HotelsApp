package com.example.hotelsapp.data.remote.dto.responses.listnearby


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("AppPresentation_queryNearToALocation")
    val appPresentationQueryNearToALocation: AppPresentationQueryNearToALocation
)