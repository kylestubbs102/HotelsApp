package com.example.hotelsapp.data.remote.dto.responses.autocomplete


import com.google.gson.annotations.SerializedName

data class SocialStatistics(
    @SerializedName("isSaved")
    val isSaved: Boolean,
    @SerializedName("__typename")
    val typename: String
)