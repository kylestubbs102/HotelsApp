package com.example.hotelsapp.data.remote.dto.responses.autocomplete


import com.google.gson.annotations.SerializedName

data class AutoCompleteLocationsResponse(
    @SerializedName("data")
    val `data`: Data
)