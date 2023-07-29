package com.example.hotelsapp.data.remote.dto.responses.autocomplete


import com.google.gson.annotations.SerializedName

data class Details(
    @SerializedName("socialStatistics")
    val socialStatistics: SocialStatistics,
    @SerializedName("__typename")
    val typename: String
)