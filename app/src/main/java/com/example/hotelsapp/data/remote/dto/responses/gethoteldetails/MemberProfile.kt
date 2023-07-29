package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class MemberProfile(
    @SerializedName("avatar")
    val avatar: Avatar,
    @SerializedName("contributionCount")
    val contributionCount: Any?,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("hometown")
    val hometown: Any?,
    @SerializedName("localizedDisplayName")
    val localizedDisplayName: LocalizedDisplayName,
    @SerializedName("profileLink")
    val profileLink: ProfileLink,
    @SerializedName("__typename")
    val typename: String
)