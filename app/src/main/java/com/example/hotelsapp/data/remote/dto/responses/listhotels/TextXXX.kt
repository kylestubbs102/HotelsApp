package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class TextXXX(
    @SerializedName("htmlString")
    val htmlString: String,
    @SerializedName("__typename")
    val typename: String
)