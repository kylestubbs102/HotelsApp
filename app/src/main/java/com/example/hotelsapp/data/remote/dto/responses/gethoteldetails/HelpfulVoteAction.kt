package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class HelpfulVoteAction(
    @SerializedName("objectId")
    val objectId: String,
    @SerializedName("objectType")
    val objectType: String,
    @SerializedName("__typename")
    val typename: String
)