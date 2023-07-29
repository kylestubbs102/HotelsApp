package com.example.hotelsapp.data.remote.dto.responses.gethoteloffers


import com.google.gson.annotations.SerializedName

data class ContentText(
    @SerializedName("htmlString")
    val htmlString: String,
    @SerializedName("__typename")
    val typename: String
)