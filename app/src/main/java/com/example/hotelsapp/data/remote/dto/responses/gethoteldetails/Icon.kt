package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class Icon(
    @SerializedName("activeName")
    val activeName: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("__typename")
    val typename: String
)