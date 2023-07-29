package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class Object(
    @SerializedName("location")
    val location: LocationX,
    @SerializedName("__typename")
    val typename: String
)