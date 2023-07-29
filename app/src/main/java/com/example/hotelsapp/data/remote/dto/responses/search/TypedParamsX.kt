package com.example.hotelsapp.data.remote.dto.responses.search


import com.google.gson.annotations.SerializedName

data class TypedParamsX(
    @SerializedName("detailId")
    val detailId: Int,
    @SerializedName("review")
    val review: Int,
    @SerializedName("__typename")
    val typename: String
)