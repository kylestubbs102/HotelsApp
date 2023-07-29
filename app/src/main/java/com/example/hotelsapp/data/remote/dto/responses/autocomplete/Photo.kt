package com.example.hotelsapp.data.remote.dto.responses.autocomplete


import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("photoSizeDynamic")
    val photoSizeDynamic: PhotoSizeDynamic,
    @SerializedName("photoSizes")
    val photoSizes: List<PhotoSize>,
    @SerializedName("__typename")
    val typename: String
)