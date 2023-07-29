package com.example.hotelsapp.data.remote.dto.requests.listnearby


import com.google.gson.annotations.SerializedName

data class Filter(
    @SerializedName("id")
    val id: Id,
    @SerializedName("value")
    val value: List<String>
)
