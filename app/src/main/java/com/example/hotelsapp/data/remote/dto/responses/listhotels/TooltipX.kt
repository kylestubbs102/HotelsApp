package com.example.hotelsapp.data.remote.dto.responses.listhotels


import com.google.gson.annotations.SerializedName

data class TooltipX(
    @SerializedName("text")
    val text: TextXXX,
    @SerializedName("tooltip")
    val tooltip: Any?,
    @SerializedName("__typename")
    val typename: String
)