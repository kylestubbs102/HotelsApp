package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("AppPresentation_queryAppDetailV2")
    val appPresentationQueryAppDetailV2: List<AppPresentationQueryAppDetailV2>
)