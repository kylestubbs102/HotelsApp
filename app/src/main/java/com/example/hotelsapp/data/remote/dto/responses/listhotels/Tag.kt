package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("localizedName")
    val localizedName: String,
    @SerializedName("tagId")
    val tagId: Int,
    @SerializedName("__typename")
    val typename: String
)