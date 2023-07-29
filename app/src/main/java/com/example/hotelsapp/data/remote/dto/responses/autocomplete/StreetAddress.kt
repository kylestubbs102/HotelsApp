package com.example.hotelsapp.data.remote.dto.responses.autocomplete


import com.google.gson.annotations.SerializedName

data class StreetAddress(
    @SerializedName("street1")
    val street1: String?,
    @SerializedName("__typename")
    val typename: String
)