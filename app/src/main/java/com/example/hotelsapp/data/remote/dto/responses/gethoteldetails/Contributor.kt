package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class Contributor(
    @SerializedName("avatar")
    val avatar: AvatarXX,
    @SerializedName("primaryInfo")
    val primaryInfo: PrimaryInfo,
    @SerializedName("secondaryInfo")
    val secondaryInfo: Any?,
    @SerializedName("__typename")
    val typename: String
)