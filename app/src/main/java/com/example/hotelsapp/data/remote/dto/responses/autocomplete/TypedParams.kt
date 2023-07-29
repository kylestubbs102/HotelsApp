package com.example.hotelsapp.data.remote.dto.responses.autocomplete


import com.google.gson.annotations.SerializedName

data class TypedParams(
    @SerializedName("geoId")
    val geoId: Int,
    @SerializedName("__typename")
    val typename: String
)