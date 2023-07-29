package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class HtmlTitle(
    @SerializedName("htmlString")
    val htmlString: String,
    @SerializedName("__typename")
    val typename: String
)