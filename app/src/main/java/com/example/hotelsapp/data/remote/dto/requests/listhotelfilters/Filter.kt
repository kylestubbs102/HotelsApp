package com.example.hotelsapp.data.remote.dto.requests.listhotelfilters


import com.google.gson.annotations.SerializedName

data class Filter(
    @SerializedName("id")
    val id: String,
    @SerializedName("value")
    val value: List<String>
)