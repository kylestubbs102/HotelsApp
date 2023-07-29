package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class Names(
    @SerializedName("name")
    val name: String,
    @SerializedName("__typename")
    val typename: String
)