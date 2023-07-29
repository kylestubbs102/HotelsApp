package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class NullableContent(
    @SerializedName("standaloneItem")
    val standaloneItem: StandaloneItem?,
    @SerializedName("text")
    val text: Text?,
    @SerializedName("title")
    val title: Title?,
    @SerializedName("__typename")
    val typename: String
)