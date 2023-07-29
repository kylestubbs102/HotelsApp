package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class DataXXXX(
    @SerializedName("attribution")
    val attribution: Attribution,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("photoSizeDynamic")
    val photoSizeDynamic: PhotoSizeDynamic,
    @SerializedName("publishedDateTime")
    val publishedDateTime: String,
    @SerializedName("sizes")
    val sizes: List<Size>,
    @SerializedName("thumbsUpVotes")
    val thumbsUpVotes: Int,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("uploadDateTime")
    val uploadDateTime: String
)