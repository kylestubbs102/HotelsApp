package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class TagsSubsection(
    @SerializedName("tagsV2")
    val tagsV2: List<TagsV2>,
    @SerializedName("__typename")
    val typename: String
)