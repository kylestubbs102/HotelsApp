package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class TypedParamsXXXXXXXXXXXXXXX(
    @SerializedName("detailId")
    val detailId: Int,
    @SerializedName("review")
    val review: Int,
    @SerializedName("__typename")
    val typename: String
)