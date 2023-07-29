package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class TagsV2(
    @SerializedName("tag")
    val tag: Tag,
    @SerializedName("text")
    val text: Any?,
    @SerializedName("__typename")
    val typename: String
)