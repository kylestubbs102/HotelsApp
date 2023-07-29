package com.example.hotelsapp.data.remote.dto.responses.autocomplete


import com.google.gson.annotations.SerializedName

data class Contact(
    @SerializedName("streetAddress")
    val streetAddress: StreetAddress,
    @SerializedName("__typename")
    val typename: String
)