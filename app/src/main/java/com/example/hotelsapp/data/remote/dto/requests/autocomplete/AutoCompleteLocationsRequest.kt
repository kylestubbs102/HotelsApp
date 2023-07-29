package com.example.hotelsapp.data.remote.dto.requests.autocomplete

import com.google.gson.annotations.SerializedName

data class AutoCompleteLocationsRequest(
    @SerializedName("query")
    val query: String,
)
