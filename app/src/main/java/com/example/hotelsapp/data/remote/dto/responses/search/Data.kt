package com.example.hotelsapp.data.remote.dto.responses.search


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("AppPresentation_queryAppSearch")
    val appPresentationQueryAppSearch: AppPresentationQueryAppSearch
)