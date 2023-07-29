package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class LocationX(
    @SerializedName("names")
    val names: Names,
    @SerializedName("__typename")
    val typename: String
)