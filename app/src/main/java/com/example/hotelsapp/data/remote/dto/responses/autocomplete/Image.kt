package com.example.hotelsapp.data.remote.dto.responses.autocomplete


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("photo")
    val photo: Photo,
    @SerializedName("__typename")
    val typename: String
)