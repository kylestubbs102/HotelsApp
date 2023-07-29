package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class CardPhotoX(
    @SerializedName("sizes")
    val sizes: Sizes,
    @SerializedName("__typename")
    val typename: String
)