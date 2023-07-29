package com.example.hotelsapp.data.remote.dto.responses.listhotelfilters


import com.google.gson.annotations.SerializedName

data class Tooltip(
    @SerializedName("dialog")
    val dialog: Any?,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("labelText")
    val labelText: Any?,
    @SerializedName("popUpText")
    val popUpText: PopUpText,
    @SerializedName("__typename")
    val typename: String
)