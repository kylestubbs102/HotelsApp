package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class UserProfile(
    @SerializedName("avatar")
    val avatar: AvatarXX,
    @SerializedName("contributionCount")
    val contributionCount: ContributionCount,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("hometown")
    val hometown: String,
    @SerializedName("localizedDisplayName")
    val localizedDisplayName: LocalizedDisplayName,
    @SerializedName("profileLink")
    val profileLink: ProfileLinkXX,
    @SerializedName("__typename")
    val typename: String
)