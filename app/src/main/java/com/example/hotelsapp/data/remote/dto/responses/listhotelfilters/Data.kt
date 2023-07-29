package com.example.hotelsapp.data.remote.dto.responses.listhotelfilters


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("AppPresentation_queryAppListV2")
    val appPresentationQueryAppListV2: List<AppPresentationQueryAppV2>
)