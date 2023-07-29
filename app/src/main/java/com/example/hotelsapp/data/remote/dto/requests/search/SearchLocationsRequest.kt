package com.example.hotelsapp.data.remote.dto.requests.search

import com.google.gson.annotations.SerializedName

data class SearchLocationsRequest(
    @SerializedName("query")
    val query: String,
    @SerializedName("updateToken")
    val updateToken: String? = null,
)
